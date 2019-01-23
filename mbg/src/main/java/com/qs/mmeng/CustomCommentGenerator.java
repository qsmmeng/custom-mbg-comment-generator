package com.qs.mmeng;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * mbg
 *
 * @author qsm
 * @date 2019/01/23
 *
 *       自定义注释生成器
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

    private Properties properties;

    private boolean suppressDate;

    private boolean suppressAllComments;

    private boolean addRemarkComments;

    private DateTimeFormatter dateTimeFormatter;

    private String projectName;

    public CustomCommentGenerator() {
        this.properties = new Properties();
        this.suppressDate = false;
        this.suppressAllComments = false;
        this.addRemarkComments = false;
        this.projectName = "";
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate =
                isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));


        suppressAllComments = isTrue(
                properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(
                properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        String dateFormatString =
                properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);

        if (StringUtility.stringHasValue(dateFormatString)) {
            dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatString);
        }

        // 这个是自定义的
        projectName = properties.getProperty("projectName");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }

        topLevelClass.addJavaDocLine("/**");
        if (StringUtility.stringHasValue(projectName)) {
            topLevelClass.addJavaDocLine(" * " + projectName);
            topLevelClass.addJavaDocLine(" * ");
        }
        topLevelClass.addJavaDocLine(" * @author " + System.getProperty("user.name"));
        topLevelClass.addJavaDocLine(" * @date " + getDateString());
        topLevelClass.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        field.addJavaDocLine("/**");

        String remarks = introspectedColumn.getRemarks();

        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" * " + remarkLine);
            }
        }
        // 数据库中对应字段没有注释，使用属性名当注释
        else {
            field.addJavaDocLine(" * " + introspectedColumn.getJavaProperty());
        }

        field.addJavaDocLine(" */");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable,
            boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * @author " + System.getProperty("user.name"));

        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");

        sb.setLength(0);
        sb.append(" * @return ");

        String remarks = introspectedColumn.getRemarks();

        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            // 只有一行注释
            if (remarkLines.length == 1) {
                sb.append(remarkLines[0]);
                method.addJavaDocLine(sb.toString());
            }
            // 多行注释
            else {
                for (int i = 0; i < remarkLines.length; i++) {
                    if (i != 0) {
                        method.addJavaDocLine(" *         " + remarkLines[i]);
                    } else {
                        sb.append(remarkLines[i]);
                        method.addJavaDocLine(sb.toString());
                    }
                }
            }
        }

        method.addJavaDocLine(" */");
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");

        // 方法参数
        Parameter param = method.getParameters().get(0);

        sb.setLength(0);
        sb.append(" * @param ");
        // 追加参数名称
        sb.append(param.getName());
        // 参数名后添加空格
        sb.append(" ");

        // 数据库字段注释
        String remarks = introspectedColumn.getRemarks();

        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            // 只有一行注释
            if (remarkLines.length == 1) {
                sb.append(remarkLines[0]);
                method.addJavaDocLine(sb.toString());
            }
            // 多行注释
            else {
                for (int i = 0; i < remarkLines.length; i++) {
                    if (i != 0) {
                        method.addJavaDocLine(" *        " + remarkLines[i]);
                    } else {
                        sb.append(remarkLines[i]);
                        method.addJavaDocLine(sb.toString());
                    }
                }
            }
        }

        method.addJavaDocLine(" */");
    }

    @Override
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else if (dateTimeFormatter != null) {
            return dateTimeFormatter.format(LocalDateTime.now());
        } else {
            return LocalDateTime.now().toString();
        }
    }
}
