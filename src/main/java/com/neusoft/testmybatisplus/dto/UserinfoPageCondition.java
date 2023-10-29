package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class UserinfoPageCondition implements Serializable {

        private UserinfoCondition userinfoCondition;
        private PageCondition pageCondition;

    public UserinfoCondition getUserinfoCondition() {
        return userinfoCondition;
    }

    public void setUserinfoCondition(UserinfoCondition userinfoCondition) {
        this.userinfoCondition = userinfoCondition;
    }

    public PageCondition getPageCondition() {
        return pageCondition;
    }

    public void setPageCondition(PageCondition pageCondition) {
        this.pageCondition = pageCondition;
    }

    @Override
    public String toString() {
        return "UserinfoPageCondition{" +
                "userinfoCondition=" + userinfoCondition +
                ", pageCondition=" + pageCondition +
                '}';
    }
}
