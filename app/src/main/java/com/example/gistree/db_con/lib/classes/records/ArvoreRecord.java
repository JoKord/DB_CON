package com.example.gistree.db_con.lib.classes.records;

import org.json.JSONException;
import org.json.JSONObject;

public class ArvoreRecord implements RecordInterface {
    private long id_tree;
    private String species;
    private String timestamp;

    public ArvoreRecord(){}
    public ArvoreRecord(ArvoreRecord arv){
        this.id_tree = arv.getId_tree();
        this.species = arv.getSpecies();
        this.timestamp = arv.getTimestamp();
    }

    @Override
    public long getId() {
        return this.id_tree;
    }
    @Override
    public void setId(long id) {
        this.id_tree = id;
    }

    public long getId_tree() {
        return this.id_tree;
    }
    public void setId_tree(long id){
        this.id_tree = id;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id_tree);
            json.put("species", this.species);
            json.put("timestamp", this.timestamp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}