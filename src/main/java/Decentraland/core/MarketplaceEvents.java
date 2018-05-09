package Decentraland.core;

public enum MarketplaceEvents {

	AUCTIONSUCCESSFUL("0xedcc7e1c269bc295dc24e74dc46b129c8449e6b0544af73b57c4201b78d119db"),
	AUCTIONCREATED("0x9493ae82b9872af74473effb9d302efba34e0df360a99cc5e577cd3f28e3cab2"),
	AUCTIONCANCELLED("0x88bd2ba46f3dc2567144331c35bd4c5ced3d547d8828638a152ddd9591c137a6");
	//OWNERSHIPTRANSFERED("")
	
	
	private String event;
	
	private MarketplaceEvents(String event) {
		this.event = event;
	}
	
	public String getEvent() {
		return event;
	}
	
}
