/**
 * Created by fellowlong on 2014-08-12.
 */

jQuery("#resumeList").jqGrid({
  url:"/talent/list.do",
  datatype: "json",
  colNames:['编号','名称', '简历报告', '原始简历', '关键字', '最后修改人', '最后修改时间'],
  colModel:[
    {name:'id',index:'id', width:55},
    {name:'name',index:'name', width:100},
    {name:'lastReportResume.name',index:'lastReportResume.name', width:100},
    {name:'lastOriginalResume.name',index:'lastOriginalResume.name', width:80, align:"right"},
    {name:'keyword',index:'keyword', width:80, align:"right"},
    {name:'updateUser',index:'updateUser', width:100},
    {name:'updateTime',index:'updateTime', width:100}
  ],
  rowNum:10,
  rowList:[10,20,30],
  pager: '#resumeListPager',
  prmNames: {page : "pageNum", rows: "pageSize"},
  postData: {colNames:'id,name,lastReportResume.name,lastOriginalResume.name,keyword,updateUser,updateTime'},
  sortname: 'id',
  viewrecords: true,
  sortorder: "desc",
//  caption:"JSON Example",
  width: "100%",
  height: "100%",
//  shrinkToFit:true,
  forceFit:true,
  autowidth:true

});
jQuery("#resumeList").jqGrid('navGrid','#resumeListPager',{edit:false,add:false,del:false});
