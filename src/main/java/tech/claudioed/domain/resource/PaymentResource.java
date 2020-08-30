package tech.claudioed.domain.resource;

import java.util.concurrent.TimeUnit;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import tech.claudioed.domain.data.TransactionRequest;
import tech.claudioed.domain.service.TransactionService;

@Path("/api/payments")
public class PaymentResource {

  private final TransactionService transactionService;

  public PaymentResource(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response pay(TransactionRequest transactionRequest,@Context UriInfo uriInfo)
      throws InterruptedException {
    final var paymentData = this.transactionService.pay(transactionRequest);
    if(paymentData.success()){
      UriBuilder builder = uriInfo.getAbsolutePathBuilder();
      builder.path(paymentData.getPayment().getId());
      return Response.created(builder.build()).entity(paymentData.getPayment()).build();
    }else{
      if(paymentData.sleep()){
        TimeUnit.SECONDS.sleep(3);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(paymentData.getPayment().getId());
        return Response.created(builder.build()).entity(paymentData.getPayment()).build();
      }else{
        return Response.status(422).build();
      }
    }
  }

}