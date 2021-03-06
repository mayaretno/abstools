/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package org.abs_models.backend.maude;

import org.abs_models.frontend.ast.Annotation;
import org.abs_models.frontend.ast.List;
import org.abs_models.frontend.ast.PureExp;
import org.abs_models.frontend.analyser.AnnotationHelper;
import org.abs_models.frontend.typechecker.Type;

import java.io.PrintStream;

public class MaudeCompilerHelper {
    public static void emitParameterValueList(PrintStream stream,
                                              List<PureExp> params,
                                              java.util.List<Type> paramTypes)
    {
        if (params.getNumChild() == 0) {
            stream.print("emp ");
        } else {
            boolean inlist = false;
            stream.print("(");
            for (int i = 0; i < params.getNumChild() ; i++) {
                PureExp param = params.getChild(i);
                Type t = paramTypes.get(i);
                boolean needConversion = t.isIntType()
                    && param.getType().isRatType();
                if (inlist) stream.print(":: "); else inlist = true;
                if (needConversion) stream.print("\"ABS.StdLib.truncate\"(");
                param.generateMaude(stream);
                if (needConversion) stream.print(")");
            }
            stream.print(") ");
        }
    }

    public static void emitCostAnnotation(PrintStream stream,
                                          List<Annotation> annotations,
                                          int defaultValue)
    {
        PureExp cost = AnnotationHelper.getAnnotationValueFromName(annotations, "ABS.DC.Cost");
        if (cost != null || defaultValue > 0) {
            stream.print("$cost(");
            if (cost == null) {
                stream.print("\"num\"[" + Integer.toString(defaultValue) + "]");
            } else {
                cost.generateMaude(stream);
            }
            stream.print(") ; ");
        }
    }

    public static void emitPushRandomInst(PrintStream stream, int count) {
        for (int x = 0; x < count; x++) {
            stream.print("$pushrandom ; ");
        }
    }
    public static void emitPopRandomInst(PrintStream stream, int count) {
        for (int x = 0; x < count; x++) {
            stream.print("; $poprandom ");
        }
    }
}
