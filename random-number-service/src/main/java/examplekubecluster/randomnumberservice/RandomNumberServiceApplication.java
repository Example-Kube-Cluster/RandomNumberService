package examplekubecluster.randomnumberservice;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import examplekubecluster.randomnumberservice.services.RandomNumberService;

@SpringBootApplication
public class RandomNumberServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		//SpringApplication.run(RandomNumberServiceApplication.class, args);
		Server server = ServerBuilder
          .forPort(8080)
          .addService(new RandomNumberService())
					.addService(ProtoReflectionService.newInstance()).build();
        server.start();
        server.awaitTermination();
	}

}
