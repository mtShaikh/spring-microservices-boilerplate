package com.taha.boilerplate.user.dto;

public class ServiceResponse<T> {

    private T data;
    private Meta meta;

    public ServiceResponse(T data){
        setData(data);
        setMeta(new Meta());
    }

    public ServiceResponse(T data, Meta meta){
        setData(data);
        setMeta(meta);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
