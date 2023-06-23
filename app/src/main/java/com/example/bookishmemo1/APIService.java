package com.example.bookishmemo1;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @GET("get")
    Call<Buku> getBuku();

    @FormUrlEncoded
    @POST("add")
    Call<BookisMemoItem>
    addKonser(
            @Field("nama_buku") String namaBuku,
            @Field("author") String author,
            @Field("genre") String genre,
            @Field("sipnosis") Integer sipnosis,
            @Field("tahun_terbit") String tahun_terbit,
            @Field("link_gambar") String link_gambar
    );

    @FormUrlEncoded
    @PUT("update/{id}")
    Call<BookisMemoItem>
    updateKonser(
            @Path("id") String id,
            @Field("nama_buku") String namaBuku,
            @Field("author") String author,
            @Field("genre") String genre,
            @Field("sipnosis") Integer sipnosis,
            @Field("tahun_terbit") String tahun_terbit,
            @Field("link_gambar") String link_gambar
    );

    @DELETE("delete/{id}")
    Call<BookisMemoItem>
    deleteKonser(
            @Path("id") String id
    );
}
