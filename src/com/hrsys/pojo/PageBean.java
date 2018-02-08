package com.hrsys.pojo;

import com.hrsys.tag.HrmConstants;

public class PageBean
{

    public PageBean()
    {
        pageSize = HrmConstants.PAGE_DEFAULT_SIZE = 4;
    }

    public int getRecordCount()
    {
        recordCount = recordCount > 0 ? recordCount : 0;
        return recordCount;
    }

    public void setRecordCount(int recordCount)
    {
        this.recordCount = recordCount;
    }

    public int getPageIndex()
    {
        pageIndex = pageIndex > 0 ? pageIndex : 1;
        pageIndex = pageIndex < getTotalSize() ? pageIndex : getTotalSize();
        return pageIndex;
    }

    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public int getPageSize()
    {
        pageSize = pageSize > HrmConstants.PAGE_DEFAULT_SIZE ? pageSize : HrmConstants.PAGE_DEFAULT_SIZE;
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalSize()
    {
        if(getRecordCount() <= 0)
            totalSize = 0;
        else
            totalSize = (getRecordCount() - 1) / getPageSize() + 1;
        return totalSize;
    }

    public int getFirstLimitParam()
    {
        return (getPageIndex() - 1) * getPageSize();
    }

    private int recordCount;
    private int pageIndex;
    private int pageSize;
    private int totalSize;
}
