package com.task.interviewtask.api;

import com.task.interviewtask.logic.DataConverter;
import com.task.interviewtask.logic.GraphQLService;
import com.task.interviewtask.model.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/getData")
public class Service2Api {
    private final DataConverter dataConverter;
    private final GraphQLService graphQLService;

    public Service2Api(DataConverter dataConverter, GraphQLService graphQLService) {
        this.dataConverter = dataConverter;
        this.graphQLService = graphQLService;
    }

//    @GetMapping
//    public ResponseEntity<List<ClientDTO>> getMainData(int size) {
//        List<SimplifiedClientDTO> simplifiedClientDTOS = new ArrayList<>();
//        for (ClientDTO client: getData(size)) {
//            SimplifiedClientDTO simplifiedClientDTO = new SimplifiedClientDTO();
//           simplifiedClientDTOS.add(new SimplifiedClientDTO().)
//        }
////return null;
////    }
//
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getChooseData(int size, String query) {
        dataConverter.covertDataStringToDataSet(query);
        return ResponseEntity.ok(graphQLService.getAllClients(size));
    }


}
