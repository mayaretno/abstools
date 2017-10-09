/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package abs.frontend.delta.traittype.dependency;

public class MethodDep extends FlatteningDependency {

    protected final String type;
    protected final int params;
    protected HasMethodDep at = null;
    public HasMethodDep getAt() {
        return at;
    }
    public void setAt(HasMethodDep at) {
        this.at = at;
    }
    public MethodDep(String use, int params){
        this.type = use;
        this.params = params;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MethodDep other = (MethodDep) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return type+"_"+params;
    }

}
