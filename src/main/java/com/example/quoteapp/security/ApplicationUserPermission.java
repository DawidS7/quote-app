package com.example.quoteapp.security;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationUserPermission {
    QUOTE_READ("quote:read"),
    QUOTE_ADD("quote:add"),
    QUOTE_DELETE("quote:delete");

    private final String permission;

    }
