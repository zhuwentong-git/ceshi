package com.mr.zwt.easybuy.vo;

/**
 * @ClassName GoodCarVO
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/26
 * @Version V1.0
 **/
public class GoodCarVO {

    private String goodId;

    private Integer count;

    private Integer maxCount;

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
