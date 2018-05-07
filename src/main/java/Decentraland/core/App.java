package Decentraland.core;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.datatypes.Event;
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
    }
    
    public App() throws Exception{
    	
    	Web3j web = Web3j.build(new HttpService("http://localhost:8545")); 
    	
    	Web3ClientVersion clientVersion = web.web3ClientVersion().send();
    	
    	System.out.println("Client Version: " + clientVersion.getWeb3ClientVersion());
    	
    	
    	
    	
    	
    	System.out.println("Syncing: " + web.ethSyncing().send().isSyncing());    	
    	
    	System.out.println("Current Block: " + web.ethBlockNumber().send().getBlockNumber());
    	
    	

    	marketplace(web);
    	
    	logBlocks(web);

    	
    	
    	
    	
    	
    }  
    
    public void logBlocks(Web3j web){
    	Subscription sub = web.blockObservable(false).subscribe(block -> {    		
    		
    		System.out.println("New Block: " + block.getBlock().getNumber());
    		
    	});
    }
    
    public void marketplace(Web3j web) throws Exception{
    	//BigInteger gasPrice = new BigInteger("2");
    	//BigInteger gasLimit = new BigInteger("21000");
    	
    	//String password = "FAoFI6qCwNW1KBGKsHwA";
    	//String source = "C:\\Program Files\\Geth\\UTC--2018-05-07T02-14-27.742326100Z--f788a15e19790ebe4edd0c84fa5eb4398ca4370a";
    	//Credentials credentials = WalletUtils.loadCredentials(password, source);
    	
    	String contract = "0xb3bca6f5052c7e24726b44da7403b56a8a1b98f8";
    	
    	//Marketplace mc = Marketplace.load(contract, web, credentials, gasPrice, gasLimit);
    	
    	
    	
    	DefaultBlockParameterNumber start = new DefaultBlockParameterNumber(5572108);
    	
    	DefaultBlockParameterNumber end = new DefaultBlockParameterNumber(5572856);

    	EthFilter auctionCalcelledFilter = new EthFilter(start, end, contract)   	
    			.addSingleTopic(EventEncoder.encode(Marketplace.AUCTIONCANCELLED_EVENT));   	
    	
    	
    	
    	web.ethLogObservable(auctionCalcelledFilter).subscribe(log -> {   		
    		System.out.println("Auction Cancelled.");
    		System.out.println("Tx Hash: " + log.getTransactionHash());    		
    	});    	
    	
    	
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
    	
    	
    }
    
}
