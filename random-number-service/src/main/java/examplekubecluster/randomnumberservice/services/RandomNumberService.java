package examplekubecluster.randomnumberservice.services;

import java.util.Random;

import examplekubecluster.randomnumberservice.NumberResponse;
import examplekubecluster.randomnumberservice.NumberRequest;
import examplekubecluster.randomnumberservice.NumberServiceGrpc.NumberServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class RandomNumberService extends NumberServiceImplBase{
  
  @Override
  public void randomNumber(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {
    responseObserver.onNext(getRandomNumber(request));
    responseObserver.onCompleted();
  }

  private NumberResponse getRandomNumber(NumberRequest upperBound){
    System.out.println("hello");
    Random rand = new Random();

    return NumberResponse.newBuilder().setNumber(rand.nextInt(upperBound.getUpperBound())).build(); 
  }
}
