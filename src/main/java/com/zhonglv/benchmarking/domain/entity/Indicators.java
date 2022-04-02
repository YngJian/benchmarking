package com.zhonglv.benchmarking.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-zhonglv-benchmarking-domain-entity-Indicators")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "indicators")
public class Indicators {
    /**
     * 自增列
     */
    @TableId(value = "I_id", type = IdType.AUTO)
    @ApiModelProperty(value = "自增列")
    private Integer iId;

    /**
     * 三级指标序号
     */
    @TableField(value = "I_number")
    @ApiModelProperty(value = "三级指标序号")
    private String iNumber;

    /**
     * 工序分类
     */
    @TableField(value = "Working_procedure_classification")
    @ApiModelProperty(value = "工序分类")
    private String workingProcedureClassification;

    /**
     * 指标类别
     */
    @TableField(value = "Category_of_indicators")
    @ApiModelProperty(value = "指标类别")
    private String categoryOfIndicators;

    /**
     * 指标
     */
    @TableField(value = "Indicators_name")
    @ApiModelProperty(value = "指标")
    private String indicatorsName;

    /**
     * 单位
     */
    @TableField(value = "Unit")
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 指标等级
     */
    @TableField(value = "Indicators_grade")
    @ApiModelProperty(value = "指标等级")
    private String indicatorsGrade;

    /**
     * 标杆企业
     */
    @TableField(value = "Benchmarking_enterprise")
    @ApiModelProperty(value = "标杆企业")
    private String benchmarkingEnterprise;

    /**
     * 标杆值
     */
    @TableField(value = "Benchmark_value")
    @ApiModelProperty(value = "标杆值")
    private String benchmarkValue;

    /**
     * 公司年平均水平基准值
     */
    @TableField(value = "Average_reference_value")
    @ApiModelProperty(value = "公司年平均水平基准值")
    private String averageReferenceValue;

    /**
     * 完成值
     */
    @TableField(value = "Completion_value")
    @ApiModelProperty(value = "完成值")
    private String completionValue;

    /**
     * 权重
     */
    @TableField(value = "Weight")
    @ApiModelProperty(value = "权重")
    private String weight;

    /**
     * 单项指标能力指数
     */
    @TableField(value = "Single_index_capability_index")
    @ApiModelProperty(value = "单项指标能力指数")
    private String singleIndexCapabilityIndex;

    /**
     * 工序综合能力指数
     */
    @TableField(value = "Process_comprehensive_capability_index")
    @ApiModelProperty(value = "工序综合能力指数")
    private String processComprehensiveCapabilityIndex;

    /**
     * 系列综合能力指数
     */
    @TableField(value = "Series_comprehensive_capability_index")
    @ApiModelProperty(value = "系列综合能力指数")
    private String seriesComprehensiveCapabilityIndex;

    /**
     * 小组
     */
    @TableField(value = "Group_name")
    @ApiModelProperty(value = "小组")
    private String groupName;

    /**
     * 分公司
     */
    @TableField(value = "Branch_company")
    @ApiModelProperty(value = "分公司")
    private String branchCompany;

    /**
     * 系列
     */
    @TableField(value = "Electrolytic_series")
    @ApiModelProperty(value = "系列")
    private String electrolyticSeries;

    /**
     * 系列名
     */
    @TableField(value = "Series_name")
    @ApiModelProperty(value = "系列名")
    private String seriesName;

    /**
     * 年
     */
    @TableField(value = "Year")
    @ApiModelProperty(value = "年")
    private String year;

    /**
     * 月
     */
    @TableField(value = "Month")
    @ApiModelProperty(value = "月")
    private String month;

    /**
     * yyyy-MM
     */
    @TableField(value = "Date_month")
    @ApiModelProperty(value = "yyyy-MM")
    private String dateMonth;

    /**
     * 录入时间（yyyy-MM-dd）
     */
    @TableField(value = "Date_enter")
    @ApiModelProperty(value = "录入时间（yyyy-MM-dd）")
    private String dateEnter;
}