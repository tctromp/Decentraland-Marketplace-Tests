package Decentaland.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class Marketplace extends Contract {
    private static final String BINARY = "606060405260008060146101000a81548160ff021916908315150217905550341561002957600080fd5b6040516040806119b183398101604052808051906020019091908051906020019091905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050611890806101216000396000f3006060604052600436106100f1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806305597d88146100f65780632be798331461011c5780633f4ba83a14610171578063451c3d8014610186578063514fcac7146101db5780635c975abb146101fe5780638174b6d71461022b57806383197ef0146102545780638456cb59146102695780638da5cb5b1461027e578063a1ba444d146102d3578063ae4f119814610308578063af8996f114610331578063d7b4010714610354578063ef46e0ca146103d4578063f2fde38b14610400578063f5074f4114610439575b600080fd5b341561010157600080fd5b61011a600480803560ff16906020019091905050610472565b005b341561012757600080fd5b61012f610525565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561017c57600080fd5b61018461054b565b005b341561019157600080fd5b610199610609565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156101e657600080fd5b6101fc600480803590602001909190505061062f565b005b341561020957600080fd5b610211610818565b604051808215151515815260200191505060405180910390f35b341561023657600080fd5b61023e61082b565b6040518082815260200191505060405180910390f35b341561025f57600080fd5b610267610831565b005b341561027457600080fd5b61027c6108c6565b005b341561028957600080fd5b610291610986565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156102de57600080fd5b61030660048080359060200190919080359060200190919080359060200190919050506109ab565b005b341561031357600080fd5b61031b610ea2565b6040518082815260200191505060405180910390f35b341561033c57600080fd5b6103526004808035906020019091905050610ea8565b005b341561035f57600080fd5b6103756004808035906020019091905050610f46565b6040518085600019166000191681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390f35b34156103df57600080fd5b6103fe6004808035906020019091908035906020019091905050610f96565b005b341561040b57600080fd5b610437600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061160e565b005b341561044457600080fd5b610470600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611763565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156104cd57600080fd5b60648160ff161015156104df57600080fd5b8060ff166004819055507f318a03d593a9ae84a371201241efc481240c14fca9adad13b0dd88e388e046296004546040518082815260200191505060405180910390a150565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156105a657600080fd5b600060149054906101000a900460ff1615156105c157600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600060149054906101000a900460ff1615151561064e57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff166003600085815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061070a57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561071557600080fd5b600360008481526020019081526020016000206000015491506003600084815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600360008481526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556002820160009055600382016000905550508073ffffffffffffffffffffffffffffffffffffffff16837f88bd2ba46f3dc2567144331c35bd4c5ced3d547d8828638a152ddd9591c137a68460405180826000191660001916815260200191505060405180910390a3505050565b600060149054906101000a900460ff1681565b60045481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561088c57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561092157600080fd5b600060149054906101000a900460ff1615151561093d57600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600060149054906101000a900460ff161515156109ca57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636352211e866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1515610a5a57600080fd5b5af11515610a6757600080fd5b5050506040518051905091508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610aad57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632972b0f030876040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1515610b7157600080fd5b5af11515610b7e57600080fd5b505050604051805190501515610b9357600080fd5b600084111515610ba257600080fd5b610bb6603c426117d790919063ffffffff16565b83111515610bc357600080fd5b42828686604051808581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c0100000000000000000000000002815260140183815260200182815260200194505050505060405180910390209050608060405190810160405280826000191681526020018373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200184815250600360008781526020019081526020016000206000820151816000019060001916905560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201556060820151816003015590505060006005541115610e3457600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd336000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff166005546040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b1515610e1157600080fd5b5af11515610e1e57600080fd5b505050604051805190501515610e3357600080fd5b5b8173ffffffffffffffffffffffffffffffffffffffff16857f9493ae82b9872af74473effb9d302efba34e0df360a99cc5e577cd3f28e3cab2838787604051808460001916600019168152602001838152602001828152602001935050505060405180910390a35050505050565b60055481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610f0357600080fd5b806005819055507fe7fa8737293f41b5dfa0d5c3e552860a06275bed7015581b083c7be7003308ba6005546040518082815260200191505060405180910390a150565b60036020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020154908060030154905084565b60008060008060149054906101000a900460ff16151515610fb657600080fd5b6003600086815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169250600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415151561102b57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415151561106657600080fd5b83600360008781526020019081526020016000206002015414151561108a57600080fd5b6003600086815260200190815260200160002060030154421015156110ae57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636352211e866040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b151561113e57600080fd5b5af1151561114b57600080fd5b5050506040518051905073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1614151561118e57600080fd5b60009150600060045411156112f9576111c560646111b7600454876117f590919063ffffffff16565b61183090919063ffffffff16565b9150600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd336000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16856040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15156112e057600080fd5b5af115156112ed57600080fd5b50505060405180519050505b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd338561134c868961184b90919063ffffffff16565b6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b151561140357600080fd5b5af1151561141057600080fd5b5050506040518051905050600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166342842e0e8433886040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b151561151357600080fd5b5af1151561152057600080fd5b50505060036000868152602001908152602001600020600001549050600360008681526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556002820160009055600382016000905550503373ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16867fedcc7e1c269bc295dc24e74dc46b129c8449e6b0544af73b57c4201b78d119db84886040518083600019166000191681526020018281526020019250505060405180910390a45050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561166957600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515156116a557600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156117be57600080fd5b8073ffffffffffffffffffffffffffffffffffffffff16ff5b60008082840190508381101515156117eb57fe5b8091505092915050565b600080600084141561180a5760009150611829565b828402905082848281151561181b57fe5b0414151561182557fe5b8091505b5092915050565b600080828481151561183e57fe5b0490508091505092915050565b600082821115151561185957fe5b8183039050929150505600a165627a7a72305820b8d6eee8f2ce43b4b6d7561c97ce90ecfbc871d158253c2a96d5710a6d6a4b8f0029";

    public static final String FUNC_SETOWNERCUT = "setOwnerCut";

    public static final String FUNC_NONFUNGIBLEREGISTRY = "nonFungibleRegistry";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_ACCEPTEDTOKEN = "acceptedToken";

    public static final String FUNC_CANCELORDER = "cancelOrder";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_OWNERCUTPERCENTAGE = "ownerCutPercentage";

    public static final String FUNC_DESTROY = "destroy";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_CREATEORDER = "createOrder";

    public static final String FUNC_PUBLICATIONFEEINWEI = "publicationFeeInWei";

    public static final String FUNC_SETPUBLICATIONFEE = "setPublicationFee";

    public static final String FUNC_AUCTIONBYASSETID = "auctionByAssetId";

    public static final String FUNC_EXECUTEORDER = "executeOrder";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_DESTROYANDSEND = "destroyAndSend";

    public static final Event AUCTIONCREATED_EVENT = new Event("AuctionCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event AUCTIONSUCCESSFUL_EVENT = new Event("AuctionSuccessful", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event AUCTIONCANCELLED_EVENT = new Event("AuctionCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    public static final Event CHANGEDPUBLICATIONFEE_EVENT = new Event("ChangedPublicationFee", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event CHANGEDOWNERCUT_EVENT = new Event("ChangedOwnerCut", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event PAUSE_EVENT = new Event("Pause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event UNPAUSE_EVENT = new Event("Unpause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    protected Marketplace(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Marketplace(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> setOwnerCut(BigInteger ownerCut) {
        final Function function = new Function(
                FUNC_SETOWNERCUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(ownerCut)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> nonFungibleRegistry() {
        final Function function = new Function(FUNC_NONFUNGIBLEREGISTRY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> unpause() {
        final Function function = new Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> acceptedToken() {
        final Function function = new Function(FUNC_ACCEPTEDTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> cancelOrder(BigInteger assetId) {
        final Function function = new Function(
                FUNC_CANCELORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> ownerCutPercentage() {
        final Function function = new Function(FUNC_OWNERCUTPERCENTAGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> destroy() {
        final Function function = new Function(
                FUNC_DESTROY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> pause() {
        final Function function = new Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createOrder(BigInteger assetId, BigInteger priceInWei, BigInteger expiresAt) {
        final Function function = new Function(
                FUNC_CREATEORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetId), 
                new org.web3j.abi.datatypes.generated.Uint256(priceInWei), 
                new org.web3j.abi.datatypes.generated.Uint256(expiresAt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> publicationFeeInWei() {
        final Function function = new Function(FUNC_PUBLICATIONFEEINWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setPublicationFee(BigInteger publicationFee) {
        final Function function = new Function(
                FUNC_SETPUBLICATIONFEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(publicationFee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<byte[], String, BigInteger, BigInteger>> auctionByAssetId(BigInteger param0) {
        final Function function = new Function(FUNC_AUCTIONBYASSETID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<byte[], String, BigInteger, BigInteger>>(
                new Callable<Tuple4<byte[], String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<byte[], String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<byte[], String, BigInteger, BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> executeOrder(BigInteger assetId, BigInteger price) {
        final Function function = new Function(
                FUNC_EXECUTEORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetId), 
                new org.web3j.abi.datatypes.generated.Uint256(price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> destroyAndSend(String _recipient) {
        final Function function = new Function(
                FUNC_DESTROYANDSEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_recipient)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Marketplace> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _acceptedToken, String _nonFungibleRegistry) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acceptedToken), 
                new org.web3j.abi.datatypes.Address(_nonFungibleRegistry)));
        return deployRemoteCall(Marketplace.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Marketplace> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _acceptedToken, String _nonFungibleRegistry) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acceptedToken), 
                new org.web3j.abi.datatypes.Address(_nonFungibleRegistry)));
        return deployRemoteCall(Marketplace.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<AuctionCreatedEventResponse> getAuctionCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(AUCTIONCREATED_EVENT, transactionReceipt);
        ArrayList<AuctionCreatedEventResponse> responses = new ArrayList<AuctionCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuctionCreatedEventResponse typedResponse = new AuctionCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.assetId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.priceInWei = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.expiresAt = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AuctionCreatedEventResponse> auctionCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AuctionCreatedEventResponse>() {
            @Override
            public AuctionCreatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUCTIONCREATED_EVENT, log);
                AuctionCreatedEventResponse typedResponse = new AuctionCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.assetId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.priceInWei = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.expiresAt = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AuctionCreatedEventResponse> auctionCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUCTIONCREATED_EVENT));
        return auctionCreatedEventObservable(filter);
    }

    public List<AuctionSuccessfulEventResponse> getAuctionSuccessfulEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(AUCTIONSUCCESSFUL_EVENT, transactionReceipt);
        ArrayList<AuctionSuccessfulEventResponse> responses = new ArrayList<AuctionSuccessfulEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuctionSuccessfulEventResponse typedResponse = new AuctionSuccessfulEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.assetId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.winner = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.totalPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AuctionSuccessfulEventResponse> auctionSuccessfulEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AuctionSuccessfulEventResponse>() {
            @Override
            public AuctionSuccessfulEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUCTIONSUCCESSFUL_EVENT, log);
                AuctionSuccessfulEventResponse typedResponse = new AuctionSuccessfulEventResponse();
                typedResponse.log = log;
                typedResponse.assetId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.winner = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.totalPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AuctionSuccessfulEventResponse> auctionSuccessfulEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUCTIONSUCCESSFUL_EVENT));
        return auctionSuccessfulEventObservable(filter);
    }

    public List<AuctionCancelledEventResponse> getAuctionCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(AUCTIONCANCELLED_EVENT, transactionReceipt);
        ArrayList<AuctionCancelledEventResponse> responses = new ArrayList<AuctionCancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuctionCancelledEventResponse typedResponse = new AuctionCancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.assetId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AuctionCancelledEventResponse> auctionCancelledEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AuctionCancelledEventResponse>() {
            @Override
            public AuctionCancelledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUCTIONCANCELLED_EVENT, log);
                AuctionCancelledEventResponse typedResponse = new AuctionCancelledEventResponse();
                typedResponse.log = log;
                typedResponse.assetId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AuctionCancelledEventResponse> auctionCancelledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUCTIONCANCELLED_EVENT));
        return auctionCancelledEventObservable(filter);
    }

    public List<ChangedPublicationFeeEventResponse> getChangedPublicationFeeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHANGEDPUBLICATIONFEE_EVENT, transactionReceipt);
        ArrayList<ChangedPublicationFeeEventResponse> responses = new ArrayList<ChangedPublicationFeeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangedPublicationFeeEventResponse typedResponse = new ChangedPublicationFeeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.publicationFee = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ChangedPublicationFeeEventResponse> changedPublicationFeeEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ChangedPublicationFeeEventResponse>() {
            @Override
            public ChangedPublicationFeeEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGEDPUBLICATIONFEE_EVENT, log);
                ChangedPublicationFeeEventResponse typedResponse = new ChangedPublicationFeeEventResponse();
                typedResponse.log = log;
                typedResponse.publicationFee = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ChangedPublicationFeeEventResponse> changedPublicationFeeEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGEDPUBLICATIONFEE_EVENT));
        return changedPublicationFeeEventObservable(filter);
    }

    public List<ChangedOwnerCutEventResponse> getChangedOwnerCutEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHANGEDOWNERCUT_EVENT, transactionReceipt);
        ArrayList<ChangedOwnerCutEventResponse> responses = new ArrayList<ChangedOwnerCutEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangedOwnerCutEventResponse typedResponse = new ChangedOwnerCutEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ownerCut = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ChangedOwnerCutEventResponse> changedOwnerCutEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ChangedOwnerCutEventResponse>() {
            @Override
            public ChangedOwnerCutEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGEDOWNERCUT_EVENT, log);
                ChangedOwnerCutEventResponse typedResponse = new ChangedOwnerCutEventResponse();
                typedResponse.log = log;
                typedResponse.ownerCut = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ChangedOwnerCutEventResponse> changedOwnerCutEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGEDOWNERCUT_EVENT));
        return changedOwnerCutEventObservable(filter);
    }

    public List<PauseEventResponse> getPauseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAUSE_EVENT, transactionReceipt);
        ArrayList<PauseEventResponse> responses = new ArrayList<PauseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PauseEventResponse typedResponse = new PauseEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PauseEventResponse> pauseEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, PauseEventResponse>() {
            @Override
            public PauseEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAUSE_EVENT, log);
                PauseEventResponse typedResponse = new PauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<PauseEventResponse> pauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAUSE_EVENT));
        return pauseEventObservable(filter);
    }

    public List<UnpauseEventResponse> getUnpauseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UNPAUSE_EVENT, transactionReceipt);
        ArrayList<UnpauseEventResponse> responses = new ArrayList<UnpauseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpauseEventResponse typedResponse = new UnpauseEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnpauseEventResponse>() {
            @Override
            public UnpauseEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UNPAUSE_EVENT, log);
                UnpauseEventResponse typedResponse = new UnpauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNPAUSE_EVENT));
        return unpauseEventObservable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public static Marketplace load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Marketplace(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Marketplace load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Marketplace(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class AuctionCreatedEventResponse {
        public Log log;

        public BigInteger assetId;

        public String seller;

        public byte[] id;

        public BigInteger priceInWei;

        public BigInteger expiresAt;
    }

    public static class AuctionSuccessfulEventResponse {
        public Log log;

        public BigInteger assetId;

        public String seller;

        public String winner;

        public byte[] id;

        public BigInteger totalPrice;
    }

    public static class AuctionCancelledEventResponse {
        public Log log;

        public BigInteger assetId;

        public String seller;

        public byte[] id;
    }

    public static class ChangedPublicationFeeEventResponse {
        public Log log;

        public BigInteger publicationFee;
    }

    public static class ChangedOwnerCutEventResponse {
        public Log log;

        public BigInteger ownerCut;
    }

    public static class PauseEventResponse {
        public Log log;
    }

    public static class UnpauseEventResponse {
        public Log log;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
