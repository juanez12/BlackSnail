package model;

public class Season{
	
	private int number;
	private int episodesPlanned;
	private int episodesIssued;
	private String trailer;
	
	public Season(int number, int episodesPlanned, int episodesIssued, String trailer){
		this.number=number;
		this.episodesPlanned=episodesPlanned;
		this.episodesIssued=episodesIssued;
		this.trailer=trailer;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number=number;
	}
	
	public int getEpisodesPlanned(){
		return episodesPlanned;
	}
	
	public void setEpisodesPlanned(int episodesPlanned){
		this.episodesPlanned=episodesPlanned;
	}
	
	public int getEpisodesIssued(){
		return episodesIssued;
	}
	
	public void setEpisodesIssued(int episodesIssued){
		this.episodesIssued=episodesIssued;
	}
	
	public String getTrailer(){
		return trailer;
	}
	
	public void setTrailer(String trailer){
		this.trailer=trailer;
	}
}