package com.qs.mmeng;

import java.util.*;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * mbg
 *
 * @author qsm
 * @date 2019/01/24
 *
 *       mybatis generator结合lombok使用
 */
public class LombokPlugin extends PluginAdapter {

    private final Set<Annotations> annotations;

    public LombokPlugin() {
        this.annotations = new LinkedHashSet<>(Annotations.values().length);
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        addAnnotations(topLevelClass);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        addAnnotations(topLevelClass);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        addAnnotations(topLevelClass);
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
            IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
            ModelClassType modelClassType) {
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
            IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
            ModelClassType modelClassType) {
        return false;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);

        // 默认注解
        annotations.add(Annotations.GETTER);
        annotations.add(Annotations.SETTER);

        // 配置属性的名字
        for (String annotationName : properties.stringPropertyNames()) {
            if (annotationName.contains(".")) {
                continue;
            }
            // 获取配置属性的值
            String value = properties.getProperty(annotationName);
            // 不是布尔值
            if (!Boolean.parseBoolean(value)) {
                continue;
            }
            Annotations annotation = Annotations.getValueOf(annotationName);
            // 非法的注解
            if (annotation == null) {
                continue;
            }

            // 添加注解自身
            annotations.add(annotation);
            // 添加相关依赖注解
            annotations.addAll(Annotations.getDependencies(annotation));
        }
    }

    /**
     * 为类添加lombok的注解
     * 
     * @param topLevelClass 类
     */
    private void addAnnotations(TopLevelClass topLevelClass) {
        for (Annotations annotation : annotations) {
            topLevelClass.addImportedType(annotation.javaType);
            topLevelClass.addAnnotation(annotation.name);
        }
    }

    private enum Annotations {

        /**
         * lombok 的 @Getter 注解
         */
        GETTER("getter", "@Getter", "lombok.Getter"),

        /**
         * lombok 的 @Setter 注解
         */
        SETTER("setter", "@Setter", "lombok.Setter"),

        /**
         * lombok 的 @NoArgsConstructor 注解
         */
        NO_ARGS_CONSTRUCTOR("noArgsConstructor", "@NoArgsConstructor", "lombok.NoArgsConstructor"),

        /**
         * lombok 的 @AllArgsConstructor 注解
         */
        ALL_ARGS_CONSTRUCTOR("allArgsConstructor", "@AllArgsConstructor",
                "lombok.AllArgsConstructor"),

        /**
         * lombok 的 @ToString 注解
         */
        TO_STRING("toString", "@ToString", "lombok.ToString");

        private final String paramName;

        private final String name;

        private final FullyQualifiedJavaType javaType;

        Annotations(String paramName, String name, String className) {
            this.paramName = paramName;
            this.name = name;
            this.javaType = new FullyQualifiedJavaType(className);
        }

        /**
         * 根据参数名获取对应的枚举
         * 
         * @param paramName 参数名
         * @return 枚举
         */
        private static Annotations getValueOf(String paramName) {
            for (Annotations item : Annotations.values()) {
                if (item.paramName.compareToIgnoreCase(paramName) == 0) {
                    return item;
                }
            }
            return null;
        }

        /**
         * 获取某枚举值的依赖
         * 
         * @param annotation 枚举值
         * @return 所有的依赖
         */
        private static Set<Annotations> getDependencies(Annotations annotation) {
            if (annotation == ALL_ARGS_CONSTRUCTOR) {
                return Collections.singleton(NO_ARGS_CONSTRUCTOR);
            }
            return Collections.emptySet();
        }

    }

}
