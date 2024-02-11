package com.yang.subject.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求实体
 */
@Data
public class PageInfo implements Serializable {

  private Long pageNo = 1L;

  private Long pageSize = 20L;

  private Long start = 0L;

  public Long getPageNo() {
    if (pageNo == null || pageNo < 1) {
      return 1L;
    }
    return pageNo;
  }

  public Long getPageSize() {
    if (pageSize == null || pageSize < 1) {
      return 20L;
    }
    return pageSize;
  }


}
