package com.example.quoteapp.security;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.example.quoteapp.security.ApplicationUserPermission.*;


@RequiredArgsConstructor
public enum ApplicationUserRole {
    USER(Sets.newHashSet(QUOTE_READ)),
    MODERATOR(Sets.newHashSet(QUOTE_READ, QUOTE_ADD)),
    ADMIN(Sets.newHashSet(QUOTE_READ, QUOTE_ADD, QUOTE_DELETE));

    private final Set<ApplicationUserPermission> permissions;

}
