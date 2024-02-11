package com.yang.subject.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页返回实体
 */
@Data
public class PageResult<T> implements Serializable {


  /**
   * 第几页
   */
  private Long pageNo = 1L;

  /**
   * 每页显示条数，默认 10
   */
  private Long pageSize = 20L;

  /**
   * 总个数
   */
  private Long total = 0L;

  private Long totalPages = 0L;

  /**
   * 返回的结果
   */
  private List<T> record = Collections.emptyList();

  private Long start = 1L;

  private Long end = 0L;

  public void setRecords(List<T> record) {
    this.record = record;
    if (record != null && record.size() > 0) {
      setTotal((long) record.size());
    }
  }

  public void setTotal(Long total) {
    this.total = total;
    if (this.pageSize > 0) {
      this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
    } else {
      this.totalPages = 0L;
    }
    this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
    this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
  }

  public void setPageSize(Long pageSize) {
    this.pageSize = pageSize;
  }

  public void setPageNo(Long pageNo) {
    this.pageNo = pageNo;
  }

}
