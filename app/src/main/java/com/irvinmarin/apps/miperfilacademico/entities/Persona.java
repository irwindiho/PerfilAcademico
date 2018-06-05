package com.irvinmarin.apps.miperfilacademico.entities;

import com.irvinmarin.apps.miperfilacademico.App;
import com.irvinmarin.apps.miperfilacademico.database.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 10/05/2018.
 */
@Table(database = AppDatabase.class)
public class Persona extends BaseModel {
    @PrimaryKey
    @Column
    int idPersona;

    @Column
    String nombres;


}
