package com.hrsys.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageTag extends SimpleTagSupport
{

    public PageTag()
    {
        style = "sabrosus";
        totalPage = 0;
    }

    public void doTag()
        throws JspException, IOException
    {
        StringBuilder res = new StringBuilder();
        StringBuilder str = new StringBuilder();
        if(recordCount > 0)
        {
            totalPage = (recordCount - 1) / pageSize + 1;
            if(pageIndex == 1)
            {
                str.append("<span class='disabled'>\u4E0A\u4E00\u9875</span>");
                calcPage(str);
                if(pageIndex == totalPage)
                {
                    str.append("<span class='disabled'>\u4E0B\u4E00\u9875</span>");
                } else
                {
                    String tempUrl = submitUrl.replace("{0}", String.valueOf(pageIndex + 1));
                    str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>\u4E0B\u4E00\u9875</a>").toString());
                }
            } else
            if(pageIndex == totalPage)
            {
                String tempUrl = submitUrl.replace("{0}", String.valueOf(pageIndex - 1));
                str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>\u4E0A\u4E00\u9875</a>").toString());
                calcPage(str);
                str.append("<span class='disabled'>\u4E0B\u4E00\u9875</span>");
            } else
            {
                String tempUrl = submitUrl.replace("{0}", String.valueOf(pageIndex - 1));
                str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>\u4E0A\u4E00\u9875</a>").toString());
                calcPage(str);
                tempUrl = submitUrl.replace("{0}", String.valueOf(pageIndex + 1));
                str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>\u4E0B\u4E00\u9875</a>").toString());
            }
            res.append((new StringBuilder("<table width='100%' align='center' style='font-size:13px;' class='")).append(style).append("'>").toString());
            res.append((new StringBuilder("<tr><td style='COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none'>")).append(str.toString()).toString());
            res.append("&nbsp;\u8DF3\u8F6C\u5230&nbsp;&nbsp;<input style='text-align: center;BORDER-RIGHT: #aaaadd 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #aaaadd 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; MARGIN: 2px; BORDER-LEFT: #aaaadd 1px solid; COLOR: #000099; PADDING-TOP: 2px; BORDER-BOTTOM: #aaaadd 1px solid; TEXT-DECORATION: none' type='text' size='2' id='pager_jump_page_size'/>");
            res.append("&nbsp;<input type='button' style='text-align: center;BORDER-RIGHT: #dedfde 1px solid; PADDING-RIGHT: 6px; BACKGROUND-POSITION: 50% bottom; BORDER-TOP: #dedfde 1px solid; PADDING-LEFT: 6px; PADDING-BOTTOM: 2px; BORDER-LEFT: #dedfde 1px solid; COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; BORDER-BOTTOM: #dedfde 1px solid; TEXT-DECORATION: none' value='\u786E\u5B9A' id='pager_jump_btn'/>");
            res.append("</td></tr>");
            res.append("<tr align='center'><td style='font-size:13px;'><tr><td style='COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none'>");
            int startNum = (pageIndex - 1) * pageSize + 1;
            int endNum = pageIndex != totalPage ? pageIndex * pageSize : recordCount;
            res.append((new StringBuilder("\u603B\u5171<font color='red'>")).append(recordCount).append("</font>\u6761\u8BB0\u5F55\uFF0C\u5F53\u524D\u663E\u793A").append(startNum).append("-").append(endNum).append("\u6761\u8BB0\u5F55\u3002").toString());
            res.append("</td></tr>");
            res.append("</table>");
            res.append("<script type='text/javascript'>");
            res.append("   document.getElementById('pager_jump_btn').onclick = function(){");
            res.append("      var page_size = document.getElementById('pager_jump_page_size').value;");
            res.append((new StringBuilder("      if (!/^[1-9]\\d*$/.test(page_size) || page_size < 1 || page_size > ")).append(totalPage).append("){").toString());
            res.append((new StringBuilder("          alert('\u8BF7\u8F93\u5165[1-")).append(totalPage).append("]\u4E4B\u95F4\u7684\u9875\u7801\uFF01');").toString());
            res.append("      }else{");
            res.append((new StringBuilder("         var submit_url = '")).append(submitUrl).append("';").toString());
            res.append("         window.location = submit_url.replace('{0}', page_size);");
            res.append("      }");
            res.append("}");
            res.append("</script>");
        } else
        {
            res.append("<table align='center' style='font-size:13px;'><tr><td style='COLOR: #0061de; MARGIN-RIGHT: 3px; PADDING-TOP: 2px; TEXT-DECORATION: none'>\u603B\u5171<font color='red'>0</font>\u6761\u8BB0\u5F55\uFF0C\u5F53\u524D\u663E\u793A0-0\u6761\u8BB0\u5F55\u3002</td></tr></table>");
        }
        getJspContext().getOut().print(res.toString());
    }

    private void calcPage(StringBuilder str)
    {
        if(totalPage <= 11)
        {
            for(int i = 1; i <= totalPage; i++)
                if(pageIndex == i)
                {
                    str.append((new StringBuilder("<span class='current'>")).append(i).append("</span>").toString());
                } else
                {
                    String tempUrl = submitUrl.replace("{0}", String.valueOf(i));
                    str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>").append(i).append("</a>").toString());
                }

        } else
        if(pageIndex <= 8)
        {
            for(int i = 1; i <= 10; i++)
                if(pageIndex == i)
                {
                    str.append((new StringBuilder("<span class='current'>")).append(i).append("</span>").toString());
                } else
                {
                    String tempUrl = submitUrl.replace("{0}", String.valueOf(i));
                    str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>").append(i).append("</a>").toString());
                }

            str.append("...");
            String tempUrl = submitUrl.replace("{0}", String.valueOf(totalPage));
            str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>").append(totalPage).append("</a>").toString());
        } else
        if(pageIndex + 8 >= totalPage)
        {
            String tempUrl = submitUrl.replace("{0}", String.valueOf(1));
            str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>1</a>").toString());
            str.append("...");
            for(int i = totalPage - 10; i <= totalPage; i++)
                if(pageIndex == i)
                {
                    str.append((new StringBuilder("<span class='current'>")).append(i).append("</span>").toString());
                } else
                {
                    tempUrl = submitUrl.replace("{0}", String.valueOf(i));
                    str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>").append(i).append("</a>").toString());
                }

        } else
        {
            String tempUrl = submitUrl.replace("{0}", String.valueOf(1));
            str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>1</a>").toString());
            str.append("...");
            for(int i = pageIndex - 4; i <= pageIndex + 4; i++)
                if(pageIndex == i)
                {
                    str.append((new StringBuilder("<span class='current'>")).append(i).append("</span>").toString());
                } else
                {
                    tempUrl = submitUrl.replace("{0}", String.valueOf(i));
                    str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>").append(i).append("</a>").toString());
                }

            str.append("...");
            tempUrl = submitUrl.replace("{0}", String.valueOf(totalPage));
            str.append((new StringBuilder("<a href='")).append(tempUrl).append("'>").append(totalPage).append("</a>").toString());
        }
    }

    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public void setRecordCount(int recordCount)
    {
        this.recordCount = recordCount;
    }

    public void setSubmitUrl(String submitUrl)
    {
        this.submitUrl = submitUrl;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }

    private static final String TAG = "{0}";
    private int pageIndex;
    private int pageSize;
    private int recordCount;
    private String submitUrl;
    private String style;
    private int totalPage;
}
