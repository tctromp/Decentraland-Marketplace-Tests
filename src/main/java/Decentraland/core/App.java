package Decentraland.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import Decentaland.contract.Marketplace;
import rx.Subscription;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			new App();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("End of main.");
    }
    
    public App() throws Exception{
    	
    	Web3j web = Web3j.build(new HttpService("http://localhost:8545")); 
    	
    	Web3ClientVersion clientVersion = web.web3ClientVersion().send();
    	
    	System.out.println("Client Version: " + clientVersion.getWeb3ClientVersion());
    	
    	
    	
    	
    	
    	System.out.println("Syncing: " + web.ethSyncing().send().isSyncing());    	
    	
    	System.out.println("Current Block: " + web.ethBlockNumber().send().getBlockNumber());
    	
    	
    	
        Event AUCTIONCANCELLED_EVENT = new Event("AuctionCancelled", 
                
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    	
        Event AUCTIONSUCCESSFUL_EVENT = new Event("AuctionSuccessful", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        ;

        System.out.println("\nAcutal: 0xedcc7e1c269bc295dc24e74dc46b129c8449e6b0544af73b57c4201b78d119db");
        
        System.out.println("Calculated: " + EventEncoder.encode(AUCTIONSUCCESSFUL_EVENT) + "\n");
        
    	marketplace(web);
    	
    	//logBlocks(web);

    	
    	
    	
    	
    	
    }  
    
    public void logBlocks(Web3j web){
    	Subscription sub = web.blockObservable(false).subscribe(block -> {    		
    		
    		System.out.println("New Block: " + block.getBlock().getNumber());
    		
    	});
    }
    
    public void marketplace(Web3j web) throws Exception{
    	BigInteger gasPrice = new BigInteger("2");
    	BigInteger gasLimit = new BigInteger("21000");
    	
    	// Note: Junk account below    	
    	String password = "FAoFI6qCwNW1KBGKsHwA";
    	String source = "C:\\Program Files\\Geth\\UTC--2018-05-07T02-14-27.742326100Z--f788a15e19790ebe4edd0c84fa5eb4398ca4370a";
    	Credentials credentials = WalletUtils.loadCredentials(password, source);
    	
    	String contract = "0xB3BCa6F5052c7e24726b44da7403b56A8A1b98f8";
    	
    	Marketplace mc = Marketplace.load(contract, web, credentials, gasPrice, gasLimit);
    	
    	System.out.println("\nContract Adress: " + mc.getContractAddress());
    	
    	System.out.println("Accepted Token: " + mc.acceptedToken().send());

    	System.out.println("Owner: " + mc.owner().send());
    	
    	System.out.println("Valid Contract: " + mc.isValid());    	
    	
    	System.out.println("Paused: " + mc.paused().send() + "\n");
    	
    	
    	DefaultBlockParameterNumber startBlock = new DefaultBlockParameterNumber(5545157);
    	
    	DefaultBlockParameterNumber endBlock = new DefaultBlockParameterNumber(5545157);

    	
    	

    	
    	
    	mc.auctionSuccessfulEventObservable(startBlock, DefaultBlockParameterName.LATEST).subscribe(onNext -> {
    		System.out.println("\nAuction Sucessful.");
    		System.out.println("Winner: " + onNext.winner.toString());
    		System.out.println("Price: " + new BigDecimal(onNext.totalPrice.toString()).divide(new BigDecimal("1000000000000000000")));
    	});
    	
    	
    	/*
    	Subscription sub = mc.auctionCancelledEventObservable(startBlock, DefaultBlockParameterName.LATEST).subscribe(onNext -> {
    		System.out.println("\nAuction Cancelled.");
    		System.out.println("Seller: " + onNext.seller);
    		byte[] id = onNext.id;
    		System.out.println("Id: " + id[0] + " " + id[1]);
    	});
    	*/
    	
    	
    	/*
    	web.transactionObservable().subscribe(tx -> {
    		System.out.println("From: " + tx.getFrom());
    		System.out.println("To: " + tx.getTo());
    		System.out.println("Transaction Value: " + new BigDecimal(tx.getValue()).divide(new BigDecimal("1000000000000000000")) + "\n");
    	});
    	*/
    	
    	
    	long lastTime = System.currentTimeMillis();
    	while(true) {
    		if(lastTime + 10000 < System.currentTimeMillis()) {
    			//System.out.println("Unsubscribed: " + sub.isUnsubscribed());
    			//sub.notify();
    			lastTime = System.currentTimeMillis();
    		}
    	}
    	
    	
    	
    	/*
    	
    	mc.auctionCreatedEventObservable(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST).subscribe(log -> {
    		System.out.println("Auction Created.");
    		System.out.println("Seller: " + log.seller);
    		System.out.println("Asset Id: " + log.assetId);
    		
    	});
    	
    	*/
   	
    	/*
    	
    	EthFilter auctionCreatedFilter = new EthFilter(start, end, contract)
    			.addSingleTopic(EventEncoder.encode(Marketplace.AUCTIONCREATED_EVENT));
    	
    	web.ethLogObservable(auctionCreatedFilter).subscribe(log -> {   		
    		System.out.println("Auction Created.");
    		System.out.println("Tx Hash: " + log.getTransactionHash());    		
    	});
    	
    	
    	EthFilter auctionSuccessfulFilter = new EthFilter(start, end, contract)
    			.addSingleTopic(EventEncoder.encode(Marketplace.AUCTIONSUCCESSFUL_EVENT));
    	
    	web.ethLogObservable(auctionSuccessfulFilter).subscribe(log -> {   		
    		System.out.println("Auction Successful.");
    		System.out.println("Tx Hash: " + log.getTransactionHash());    		
    	});
    	
    	*/
    }
    
}
