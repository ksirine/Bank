package org.bank.ws;
import org.apache.commons.collections4.CollectionUtils;
import org.bank.Entity.Account;
import org.bank.Entity.Operation;
import org.bank.service.AccountService;
import org.bank.service.OperationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
public class OperationWS {

    private static final String DEPOSIT = "D";

    private static final String WITHDRAWAL = "W";

    private OperationService operationService;
    private AccountService accountService;

    @Inject
    public OperationWS(OperationService operationService,
                       AccountService accountService) {
        this.accountService = accountService;
        this.operationService = operationService;
    }

    /** Method to update account's balance
     * and add the operation
     * @Param account
     * @Param operation
     *
     * */
    @GET
    @Path("/accountId/{accountId}")
    public Account findByAccountId(@PathParam("accountId") String accountId) {
        return accountService.findByAccountId(accountId);
    }

    /** Method to update account's balance
     * and add the operation
     * @Param account
     * @Param operation
     *
     * */
    @PUT
    @Path("/operation/{accountId}")
    public String doAnOpertation(@PathParam("accountId") String accountId, Operation operation) {
        if (operation != null && accountId != null) {
            Account account = accountService.findByAccountId(accountId);
            if (account != null) {
                if (operation.getOperationType().equals(WITHDRAWAL)) {
                    account.setBalance(account.getBalance() - operation.getAmount());
                    accountService.update(account);
                }
                if (operation.getOperationType().equals(DEPOSIT)) {
                    account.setBalance(account.getBalance() + operation.getAmount());
                    accountService.update(account);
                }
                operationService.save(operation);
                return "Operation Done";
            }
        }
        return "Operation Failed";
    }
    /** Method to get Account's operations
     * @Param accountId
     *
     * */
    @GET
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operation> findAllOperationByAccountId(@PathParam("accountId") String accountId) throws Exception {
        List<Operation> operations = operationService.findByAccountId(accountId);
        if (CollectionUtils.isEmpty(operations)) {
            throw new Exception("No Operation is found for this account");
        }
       return operations;
    }

}
