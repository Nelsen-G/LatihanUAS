package com.example.latihanuas6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment implements ItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewFragment newInstance(String param1, String param2) {
        ViewFragment fragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView rvData;

    private RecyclerViewAdapter rvAdapter;

    private ArrayList<Student> listStudent;
    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        dbHelper = new DBHelper(requireContext());

        listStudent = dbHelper.getAllStudents();

        rvData = view.findViewById(R.id.rvData);

        rvAdapter = new RecyclerViewAdapter(listStudent, requireContext());

        rvData.setAdapter(rvAdapter);
        rvData.setLayoutManager(new LinearLayoutManager(requireContext()));

        rvAdapter.setItemClickListener(this);
        rvAdapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onClicked(View view, int position) {
        Student s = listStudent.get(position);

        Bundle b = new Bundle();
        b.putString("name", s.getName());
        b.putInt("nim", s.getNim());
        b.putString("email", s.getEmail());
        b.putInt("hp", s.getHp());

        Fragment detailFragment = new DetailFragment();
        detailFragment.setArguments(b);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, detailFragment).commit();

    }
}