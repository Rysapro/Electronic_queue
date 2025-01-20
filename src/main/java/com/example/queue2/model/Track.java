package com.example.queue2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import java.sql.SQLType;
import org.hibernate.annotations.JdbcTypeCode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableName;
    private String operationType;
    private Long recordId;
//    @JdbcTypeCode(SQLType.JSON)
//    private String infoChangedData;
//    @JdbcTypeCode(SQLType.JSON)
//    private String infoOldData;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Queue<User> changedBy = new LinkedList<>();
    private Timestamp changedTime;


}
