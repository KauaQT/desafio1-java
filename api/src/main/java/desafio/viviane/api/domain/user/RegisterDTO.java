package desafio.viviane.api.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
