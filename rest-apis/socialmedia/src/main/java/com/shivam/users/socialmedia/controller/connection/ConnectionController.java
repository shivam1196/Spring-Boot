package com.shivam.users.socialmedia.controller.connection;


import com.shivam.users.socialmedia.model.connection.Connection;
import com.shivam.users.socialmedia.model.connection.requestmodel.GetConnectionRequest;
import com.shivam.users.socialmedia.model.connection.requestmodel.SetConnectionRequest;
import com.shivam.users.socialmedia.service.connection.ConnectionServiceLayerImp;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMongoRepositories
public class ConnectionController {
  @Autowired
  private ConnectionServiceLayerImp connectionServiceLayerImp;

  @PostMapping(value = "/makeConnectionRequest",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> makeConnectionRequest(@RequestBody SetConnectionRequest setConnectionRequest){
    connectionServiceLayerImp.addConnectionRequest(setConnectionRequest);
    return new ResponseEntity<>("Connection Send", HttpStatus.OK);
  }

  @PostMapping(value = "/getAllConnectionRequest",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<Connection>> getAllConnectionRequest(@RequestBody GetConnectionRequest getConnectionRequest){
    Optional<Connection> connection = connectionServiceLayerImp.getConnectionRequest(getConnectionRequest.getConnectionId());
    return new ResponseEntity<>(connection,HttpStatus.OK);
  }

}
