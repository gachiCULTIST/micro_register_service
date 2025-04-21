package gachi.nikola.service.register.client;

import gachi.nikola.service.register.dto.DataBaseUserResponseDto;
import gachi.nikola.service.register.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "database-service", url = "${service.database.url}")
public interface DataBaseClient {

    @PostMapping("/database/api/v1/user")
    DataBaseUserResponseDto addUser(@RequestBody UserDto userDto);
}
