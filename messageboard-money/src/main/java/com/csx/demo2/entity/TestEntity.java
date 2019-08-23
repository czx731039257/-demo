package com.csx.demo2.entity;

public class TestEntity {

    private String a;
    private String b;
    private String c;
    private String d;

    private TestEntity(Builder builder) {
        a = builder.a;
        b = builder.b;
        c = builder.c;
        d = builder.d;
    }

    public static class Builder {
        private String a;
        private String b;
        private String c;
        private String d;

        public Builder() {
        }

        public Builder a(String val) {
            a = val;
            return this;
        }

        public Builder b(String val) {
            b = val;
            return this;
        }

        public Builder c(String val) {
            c = val;
            return this;
        }

        public Builder d(String val) {
            d = val;
            return this;
        }

        public TestEntity build() {
            return new TestEntity(this);
        }
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
