package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkapartment.adapter.ItemAdapter;
import com.example.checkapartment.databinding.FragmentFirstBinding;
import com.example.checkapartment.model.Item;

import java.util.ArrayList;
import java.util.List;

public  class FirstFragment extends Fragment implements ItemAdapter.SendItem{

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        RecyclerView mRecyclerView = binding.rvItem;
        ItemAdapter adapter = new ItemAdapter(returnItemList(), getContext(), (ItemAdapter.SendItem) this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private List<Item> returnItemList() {
        List <Item> listItem = new ArrayList<>();
        Item item01 = new Item("Edificio Pereira");
        listItem.add(item01);
        Item item02 = new Item("Edificio Consistorial");
        listItem.add(item02);
        Item item03 = new Item("Edificio Moneda");
        listItem.add(item03);
        Item item04 = new Item("Edificio Prat");
        listItem.add(item04);
        Item item05 = new Item("Edificio Amunategui");
        listItem.add(item05);
        Item item06 = new Item("Edificio Balmaceda");
        listItem.add(item06);
        Item item07 = new Item("Edificio Telefonica");
        listItem.add(item07);
        Item item08 = new Item("Edificio Nuevo Horizonte");
        listItem.add(item08);
        Item item09 = new Item("Edificio Huerfanos");
        listItem.add(item09);
        Item item10 = new Item("Edificio Morandé");
        listItem.add(item10);
        return listItem;
    }

    @Override
    public void sendItem(Item item) {
        Bundle bundle = new Bundle();
        bundle.putString("name", item.getItemDescription());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}