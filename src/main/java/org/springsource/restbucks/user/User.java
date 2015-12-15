package org.springsource.restbucks.user;

import lombok.*;
import org.springsource.restbucks.core.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "RBUser")
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class User extends AbstractEntity {

    private @NotNull String login;

}
