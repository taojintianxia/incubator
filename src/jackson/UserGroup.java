package jackson;

import java.util.List;

import lombok.Data;

@Data
public class UserGroup implements testinterface{
	private String id;
	private String status;
	private String page;
	private List<User> Users;
}
