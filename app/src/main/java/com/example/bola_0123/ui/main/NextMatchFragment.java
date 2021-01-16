package com.example.bola_0123.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bola_0123.ApiClient;
import com.example.bola_0123.ApiService;
import com.example.bola_0123.Match;
import com.example.bola_0123.MatchResponse;
import com.example.bola_0123.NextMatchAdapter;
import com.example.bola_0123.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NextMatchFragment extends Fragment {

    private ArrayList<Match> listMatch;
    private RecyclerView rvMatch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_next_match, container, false);
        rvMatch = view.findViewById(R.id.rv_nextmatch);
        rvMatch.setHasFixedSize(true);
        rvMatch.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<MatchResponse> call = service.getNextMatch("4335");
        call.enqueue(new Callback<MatchResponse>() {
            @Override
            public void onResponse(Call<MatchResponse> call, Response<MatchResponse> response) {

                listMatch = response.body().getEvents();

                NextMatchAdapter nextmatchAdapter = new NextMatchAdapter(listMatch);
                rvMatch.setAdapter(nextmatchAdapter);
            }

            @Override
            public void onFailure(Call<MatchResponse> call, Throwable t) {

            }
        });



        return view;
    }
}