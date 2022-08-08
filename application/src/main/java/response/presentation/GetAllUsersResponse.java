package response.presentation;

import dto.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
public class GetAllUsersResponse {
    private List<User> userList;
}
