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
    private static final String BINARY = "60606040526000805460a060020a60ff0219169055341561001f57600080fd5b604051604080610e64833981016040528080519190602001805160008054600160a060020a03338116600160a060020a031992831617909255600180549683169682169690961790955560028054919092169416939093179092555050610dd98061008b6000396000f3006060604052600436106100d75763ffffffff60e060020a60003504166305597d8881146100dc5780632be79833146100f75780633f4ba83a14610126578063451c3d8014610139578063514fcac71461014c5780635c975abb146101625780638174b6d71461018957806383197ef0146101ae5780638456cb59146101c15780638da5cb5b146101d4578063a1ba444d146101e7578063ae4f119814610203578063af8996f114610216578063d7b401071461022c578063ef46e0ca14610276578063f2fde38b1461028f578063f5074f41146102ae575b600080fd5b34156100e757600080fd5b6100f560ff600435166102cd565b005b341561010257600080fd5b61010a610337565b604051600160a060020a03909116815260200160405180910390f35b341561013157600080fd5b6100f5610346565b341561014457600080fd5b61010a6103c5565b341561015757600080fd5b6100f56004356103d4565b341561016d57600080fd5b6101756104c3565b604051901515815260200160405180910390f35b341561019457600080fd5b61019c6104d3565b60405190815260200160405180910390f35b34156101b957600080fd5b6100f56104d9565b34156101cc57600080fd5b6100f5610502565b34156101df57600080fd5b61010a610586565b34156101f257600080fd5b6100f5600435602435604435610595565b341561020e57600080fd5b61019c610889565b341561022157600080fd5b6100f560043561088f565b341561023757600080fd5b6102426004356108e5565b604051938452600160a060020a03909216602084015260408084019190915260608301919091526080909101905180910390f35b341561028157600080fd5b6100f5600435602435610917565b341561029a57600080fd5b6100f5600160a060020a0360043516610c7d565b34156102b957600080fd5b6100f5600160a060020a0360043516610d18565b60005433600160a060020a039081169116146102e857600080fd5b606460ff8216106102f857600080fd5b60ff811660048190557f318a03d593a9ae84a371201241efc481240c14fca9adad13b0dd88e388e046299060405190815260200160405180910390a150565b600254600160a060020a031681565b60005433600160a060020a0390811691161461036157600080fd5b60005460a060020a900460ff16151561037957600080fd5b6000805474ff0000000000000000000000000000000000000000191690557f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b600154600160a060020a031681565b60008054819060a060020a900460ff16156103ee57600080fd5b60008381526003602052604090206001015433600160a060020a0390811691161480610428575060005433600160a060020a039081169116145b151561043357600080fd5b50506000818152600360208190526040808320805460018201805486845573ffffffffffffffffffffffffffffffffffffffff1981169091556002830186905591909301939093559091600160a060020a031690819084907f88bd2ba46f3dc2567144331c35bd4c5ced3d547d8828638a152ddd9591c137a69085905190815260200160405180910390a3505050565b60005460a060020a900460ff1681565b60045481565b60005433600160a060020a039081169116146104f457600080fd5b600054600160a060020a0316ff5b60005433600160a060020a0390811691161461051d57600080fd5b60005460a060020a900460ff161561053457600080fd5b6000805474ff0000000000000000000000000000000000000000191660a060020a1790557f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b600054600160a060020a031681565b60008054819060a060020a900460ff16156105af57600080fd5b600254600160a060020a0316636352211e8660405160e060020a63ffffffff84160281526004810191909152602401602060405180830381600087803b15156105f757600080fd5b5af1151561060457600080fd5b505050604051805192505033600160a060020a039081169083161461062857600080fd5b600254600160a060020a0316632972b0f0308760405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b151561067e57600080fd5b5af1151561068b57600080fd5b5050506040518051905015156106a057600080fd5b600084116106ad57600080fd5b6106be42603c63ffffffff610d3f16565b83116106c957600080fd5b42828686604051938452600160a060020a03929092166c01000000000000000000000000026020840152603483015260548201526074016040518091039020905060806040519081016040908152828252600160a060020a03841660208084019190915281830187905260608301869052600088815260039091522081518155602082015160018201805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905560408201518160020155606082015181600301559050506000600554111561083057600154600054600554600160a060020a03928316926323b872dd92339291169060405160e060020a63ffffffff8616028152600160a060020a0393841660048201529190921660248201526044810191909152606401602060405180830381600087803b151561080e57600080fd5b5af1151561081b57600080fd5b50505060405180519050151561083057600080fd5b81600160a060020a0316857f9493ae82b9872af74473effb9d302efba34e0df360a99cc5e577cd3f28e3cab283878760405192835260208301919091526040808301919091526060909101905180910390a35050505050565b60055481565b60005433600160a060020a039081169116146108aa57600080fd5b60058190557fe7fa8737293f41b5dfa0d5c3e552860a06275bed7015581b083c7be7003308ba8160405190815260200160405180910390a150565b600360208190526000918252604090912080546001820154600283015492909301549092600160a060020a0316919084565b600080548190819060a060020a900460ff161561093357600080fd5b600085815260036020526040902060010154600160a060020a0316925082151561095c57600080fd5b33600160a060020a031683600160a060020a03161415151561097d57600080fd5b600085815260036020526040902060020154841461099a57600080fd5b6000858152600360208190526040909120015442106109b857600080fd5b600254600160a060020a0316636352211e8660405160e060020a63ffffffff84160281526004810191909152602401602060405180830381600087803b1515610a0057600080fd5b5af11515610a0d57600080fd5b5050506040518051600160a060020a038581169116149050610a2e57600080fd5b6000915060006004541115610ae957610a636064610a5760045487610d5990919063ffffffff16565b9063ffffffff610d8416565b600154600054919350600160a060020a03908116916323b872dd913391168560405160e060020a63ffffffff8616028152600160a060020a0393841660048201529190921660248201526044810191909152606401602060405180830381600087803b1515610ad157600080fd5b5af11515610ade57600080fd5b505050604051805150505b600154600160a060020a03166323b872dd3385610b0c888763ffffffff610d9b16565b60405160e060020a63ffffffff8616028152600160a060020a0393841660048201529190921660248201526044810191909152606401602060405180830381600087803b1515610b5b57600080fd5b5af11515610b6857600080fd5b50505060405180515050600254600160a060020a03166342842e0e84338860405160e060020a63ffffffff8616028152600160a060020a0393841660048201529190921660248201526044810191909152606401600060405180830381600087803b1515610bd557600080fd5b5af11515610be257600080fd5b5050506000858152600360208190526040808320805484825560018201805473ffffffffffffffffffffffffffffffffffffffff19169055600282018590559201929092559150600160a060020a03338116919085169087907fedcc7e1c269bc295dc24e74dc46b129c8449e6b0544af73b57c4201b78d119db90859089905191825260208201526040908101905180910390a45050505050565b60005433600160a060020a03908116911614610c9857600080fd5b600160a060020a0381161515610cad57600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60005433600160a060020a03908116911614610d3357600080fd5b80600160a060020a0316ff5b600082820183811015610d4e57fe5b8091505b5092915050565b600080831515610d6c5760009150610d52565b50828202828482811515610d7c57fe5b0414610d4e57fe5b6000808284811515610d9257fe5b04949350505050565b600082821115610da757fe5b509003905600a165627a7a72305820d3c668fb632df9e8b0680ba1d9425e8d5aa102c9ef7a604a3ab01ef40cc73d5c0029";

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
