package com.enstax.cesarcano.hellogas.domain.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Comentario {
    private int id;
    private String usuario_id;
    private float calificacion;
    private String comentario;
    private long fecha_creacion;
    private int likes;
    private int dislikes;
    private int item_id;
    private int user_id;

    public Comentario() {
    }

    public Comentario(int id, String usuario_id, float calificacion, String comentario, int likes, int dislikes, int item_id) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.likes = likes;
        this.dislikes = dislikes;
        this.item_id = item_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public long getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(long fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}