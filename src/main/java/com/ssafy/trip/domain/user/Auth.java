package com.ssafy.trip.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Auth {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String accessToken;
    private String refreshToken;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void accessUpdate(String accessToken) {
        this.accessToken = accessToken;
    }

    public void refreshUpdate(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
