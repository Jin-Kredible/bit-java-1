package com.bit.project1;

import java.util.*;

public class ForumListSave {

	private ArrayList<Integer> seqNo= new ArrayList<Integer>();
	private ArrayList<String> title	= new ArrayList<String>();
	private ArrayList<String> content = new ArrayList<String>();
	private ArrayList<String> writer = new ArrayList<String>();
	private ArrayList<String> wdate = new ArrayList<String>();
	private ArrayList<String> wtime = new ArrayList<String>();
	private boolean nextPage = true;
	
	public ForumListSave() {}
	
	public void setSeqNo(int index, Integer seqno){
		this.seqNo.add(index, seqno);
	}
	
	public void setTitle(int index, String title){
		this.title.add(index, title);
	}
	
	public void setContent(int index, String content){
		this.content.add(index, content);
	}
	
	public void setWriter(int index, String writer){
		this.writer.add(index, writer);
	}
	
	public void setWdate(int index, String date){
		this.wdate.add(index, date);
	}
	
	public void setWtime(int index, String time){
		this.wtime.add(index, time);
	}
	
	public Integer[] getSeqNo(){
		return this.seqNo.toArray(new Integer[seqNo.size()]);
	}
	
	public String[] getTitle() {
		return this.title.toArray(new String[title.size()]);
	}
	
	public String[] getContent() {
		return this.content.toArray(new String[content.size()]);
	}
	
	public String[] getWriter() {
		return this.writer.toArray(new String[writer.size()]);
	}
	
	public String[] getWdate() {
		return this.wdate.toArray(new String[wdate.size()]);
	}
	
	public String[] getWtime() {
		return this.wtime.toArray(new String[wtime.size()]);
	}
	
	public int	getListSize() {
		return seqNo.size();
	}
	
	public boolean isNextPage() {
		return nextPage;
	}
	
	public void setNextPage(boolean nextPage) {
		this.nextPage=nextPage;
	}
}
