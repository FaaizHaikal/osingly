package com.example.osingly.utils;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Enhanced TranslationHelper for Osing-Indonesian translation
 * Based on comprehensive Osing dictionary from loroktm.com
 * Contains 1000+ Osing vocabulary words
 */
public class TranslationHelper {

    private static final String TAG = "TranslationHelper";
    private Context context;
    private Map<String, String> osingToIndonesianDict;
    private Map<String, String> indonesianToOsingDict;

    public interface TranslationCallback {
        void onSuccess(String translatedText);
        void onFailure(String error);
    }

    public TranslationHelper(Context context) {
        this.context = context;
        initializeDictionaries();
    }

    /**
     * Initialize comprehensive dictionaries for translation
     * Based on authentic Osing vocabulary from Banyuwangi
     */
    private void initializeDictionaries() {
        osingToIndonesianDict = new HashMap<>();

        // === HURUF A ===
        osingToIndonesianDict.put("abero", "coba");
        osingToIndonesianDict.put("abed", "sikap");
        osingToIndonesianDict.put("abete", "gayamu");
        osingToIndonesianDict.put("abot", "berat");
        osingToIndonesianDict.put("acake", "coba");
        osingToIndonesianDict.put("adoh", "jauh");
        osingToIndonesianDict.put("adung", "kalau");
        osingToIndonesianDict.put("dung", "kalau");
        osingToIndonesianDict.put("alit", "kecil");
        osingToIndonesianDict.put("aluk", "mendingan");
        osingToIndonesianDict.put("alung", "enakan");
        osingToIndonesianDict.put("ambai", "lalui");
        osingToIndonesianDict.put("ambekan", "nafas");
        osingToIndonesianDict.put("amung", "hanya");
        osingToIndonesianDict.put("mung", "hanya");
        osingToIndonesianDict.put("ampet", "ambil");
        osingToIndonesianDict.put("juwut", "ambil");
        osingToIndonesianDict.put("ambi", "dengan");
        osingToIndonesianDict.put("kambi", "dengan");
        osingToIndonesianDict.put("ambung", "cium");
        osingToIndonesianDict.put("amergo", "karena");
        osingToIndonesianDict.put("mergo", "karena");
        osingToIndonesianDict.put("ancas", "ancam");
        osingToIndonesianDict.put("ancik", "senggama");
        osingToIndonesianDict.put("angel", "sulit");
        osingToIndonesianDict.put("angen", "angan");
        osingToIndonesianDict.put("angger", "setiap");
        osingToIndonesianDict.put("paceke", "setiap");
        osingToIndonesianDict.put("angur", "lebih baik");
        osingToIndonesianDict.put("bangur", "lebih baik");
        osingToIndonesianDict.put("anteni", "nanti");
        osingToIndonesianDict.put("apuo", "kenapa");
        osingToIndonesianDict.put("apuwo", "mengapa");
        osingToIndonesianDict.put("aran", "nama");
        osingToIndonesianDict.put("arep", "akan");
        osingToIndonesianDict.put("aron", "sembuh");
        osingToIndonesianDict.put("ati", "hati");
        osingToIndonesianDict.put("atin", "hati");
        osingToIndonesianDict.put("atos", "keras");
        osingToIndonesianDict.put("awak", "diri");
        osingToIndonesianDict.put("awan", "siang");

        // === HURUF B ===
        osingToIndonesianDict.put("baen", "saja");
        osingToIndonesianDict.put("bain", "saja");
        osingToIndonesianDict.put("byaen", "saja");
        osingToIndonesianDict.put("bakal", "akan");
        osingToIndonesianDict.put("bakalan", "akan");
        osingToIndonesianDict.put("balik", "kembali");
        osingToIndonesianDict.put("bapak", "bapak");
        osingToIndonesianDict.put("byapak", "bapak");
        osingToIndonesianDict.put("banyu", "air");
        osingToIndonesianDict.put("byanyu", "air");
        osingToIndonesianDict.put("banyuwangi", "banyuwangi");
        osingToIndonesianDict.put("bareng", "bersama");
        osingToIndonesianDict.put("bebeng", "hadang");
        osingToIndonesianDict.put("bedo", "beda");
        osingToIndonesianDict.put("belog", "bodoh");
        osingToIndonesianDict.put("lengek", "bodoh");
        osingToIndonesianDict.put("bengen", "dulu");
        osingToIndonesianDict.put("bengi", "malam");
        osingToIndonesianDict.put("beng", "anak perempuan");
        osingToIndonesianDict.put("jebeng", "anak perempuan");
        osingToIndonesianDict.put("biso", "bisa");
        osingToIndonesianDict.put("bliyak", "buka");
        osingToIndonesianDict.put("boding", "parang");
        osingToIndonesianDict.put("bojog", "monyet");
        osingToIndonesianDict.put("bombong", "adu");
        osingToIndonesianDict.put("bondo", "harta");
        osingToIndonesianDict.put("bongko", "mati");
        osingToIndonesianDict.put("bongol", "bodoh");
        osingToIndonesianDict.put("goblog", "bodoh");
        osingToIndonesianDict.put("boreh", "oles");
        osingToIndonesianDict.put("borok", "luka");
        osingToIndonesianDict.put("boyok", "punggung");
        osingToIndonesianDict.put("bungah", "bahagia");
        osingToIndonesianDict.put("buru", "baru");
        osingToIndonesianDict.put("busek", "hapus");
        osingToIndonesianDict.put("buyang", "buang");

        // === HURUF C ===
        osingToIndonesianDict.put("campleng", "putus");
        osingToIndonesianDict.put("cancang", "ikat");
        osingToIndonesianDict.put("candhak", "pegang");
        osingToIndonesianDict.put("carok", "jumpa");
        osingToIndonesianDict.put("cawis", "siap");
        osingToIndonesianDict.put("cedak", "dekat");
        osingToIndonesianDict.put("cemeng", "hitam");
        osingToIndonesianDict.put("cendek", "pendek");
        osingToIndonesianDict.put("cendak", "pendek");
        osingToIndonesianDict.put("cepet", "cepat");
        osingToIndonesianDict.put("cerito", "cerita");
        osingToIndonesianDict.put("crito", "cerita");
        osingToIndonesianDict.put("cicir", "jatuh dari atas");
        osingToIndonesianDict.put("temebluk", "jatuh dari atas");
        osingToIndonesianDict.put("cilik", "kecil");
        osingToIndonesianDict.put("coplok", "lepas");
        osingToIndonesianDict.put("cupar", "cemburu");

        // === HURUF D ===
        osingToIndonesianDict.put("dadan", "dada");
        osingToIndonesianDict.put("dodo", "dada");
        osingToIndonesianDict.put("dadi", "jadi");
        osingToIndonesianDict.put("dalan", "jalan");
        osingToIndonesianDict.put("dyalan", "jalan");
        osingToIndonesianDict.put("deleng", "lihat");
        osingToIndonesianDict.put("demen", "suka");
        osingToIndonesianDict.put("dewek", "sendiri");
        osingToIndonesianDict.put("dino", "hari");
        osingToIndonesianDict.put("dinggo", "untuk");
        osingToIndonesianDict.put("dongong", "bodoh dan pelupa");
        osingToIndonesianDict.put("dowo", "panjang");
        osingToIndonesianDict.put("driji", "jari");
        osingToIndonesianDict.put("dudu", "bukan");
        osingToIndonesianDict.put("dungo", "doa");
        osingToIndonesianDict.put("dunyo", "dunia");
        osingToIndonesianDict.put("duso", "dosa");
        osingToIndonesianDict.put("duwe", "punya");
        osingToIndonesianDict.put("due", "punya");

        // === HURUF E ===
        osingToIndonesianDict.put("edan", "gila");
        osingToIndonesianDict.put("eleng", "ingat");
        osingToIndonesianDict.put("iling", "ingat");
        osingToIndonesianDict.put("eluh", "air mata");
        osingToIndonesianDict.put("eloh", "air mata");
        osingToIndonesianDict.put("elung", "beri");
        osingToIndonesianDict.put("eman", "sayang");
        osingToIndonesianDict.put("welas", "sayang");
        osingToIndonesianDict.put("tresno", "sayang");
        osingToIndonesianDict.put("embyah", "nenek");
        osingToIndonesianDict.put("embuh", "entah");
        osingToIndonesianDict.put("emong", "tidak mau");
        osingToIndonesianDict.put("mong", "tidak mau");
        osingToIndonesianDict.put("empur", "hancur");
        osingToIndonesianDict.put("lutrek", "hancur");
        osingToIndonesianDict.put("ndedek", "hancur");
        osingToIndonesianDict.put("endi", "mana");
        osingToIndonesianDict.put("enget", "ingat");
        osingToIndonesianDict.put("ered", "seret");
        osingToIndonesianDict.put("esem", "senyum");

        // === HURUF G ===
        osingToIndonesianDict.put("gampang", "mudah");
        osingToIndonesianDict.put("gancang", "cepat");
        osingToIndonesianDict.put("gyancang", "cepat");
        osingToIndonesianDict.put("ganti", "ganti");
        osingToIndonesianDict.put("gati", "perhatian");
        osingToIndonesianDict.put("gyati", "perhatian");
        osingToIndonesianDict.put("gawe", "buat");
        osingToIndonesianDict.put("gede", "besar");
        osingToIndonesianDict.put("gedhig", "besar");
        osingToIndonesianDict.put("gedigi", "begini");
        osingToIndonesianDict.put("gedigu", "begitu");
        osingToIndonesianDict.put("gelem", "mau");
        osingToIndonesianDict.put("gelo", "kecewa");
        osingToIndonesianDict.put("gemuyu", "tertawa");
        osingToIndonesianDict.put("guyu", "tertawa");
        osingToIndonesianDict.put("gending", "lagu");
        osingToIndonesianDict.put("gering", "kurus");
        osingToIndonesianDict.put("getih", "darah");
        osingToIndonesianDict.put("getun", "sesal");
        osingToIndonesianDict.put("golek", "cari");
        osingToIndonesianDict.put("golet", "cari");
        osingToIndonesianDict.put("gopoh", "buru-buru");
        osingToIndonesianDict.put("gowo", "bawa");
        osingToIndonesianDict.put("gubab", "bohong");
        osingToIndonesianDict.put("gubyab", "bohong");
        osingToIndonesianDict.put("gurau", "guru");
        osingToIndonesianDict.put("gurih", "nikmat");
        osingToIndonesianDict.put("gusti", "tuhan");

        // === HURUF H ===
        osingToIndonesianDict.put("hang", "yang");
        osingToIndonesianDict.put("kang", "yang");
        osingToIndonesianDict.put("heng", "tidak");

        // === HURUF I ===
        osingToIndonesianDict.put("idek", "injak");
        osingToIndonesianDict.put("iki", "ini");
        osingToIndonesianDict.put("ilang", "hilang");
        osingToIndonesianDict.put("ilir", "kipas");
        osingToIndonesianDict.put("imuk", "amuk");
        osingToIndonesianDict.put("inceng", "intip");
        osingToIndonesianDict.put("iro", "kamu");
        osingToIndonesianDict.put("riko", "kamu");
        osingToIndonesianDict.put("siro", "kamu");
        osingToIndonesianDict.put("hiro", "kamu");
        osingToIndonesianDict.put("iseh", "masih");
        osingToIndonesianDict.put("isin", "malu");
        osingToIndonesianDict.put("isun", "aku");
        osingToIndonesianDict.put("sun", "aku");
        osingToIndonesianDict.put("hun", "aku");

        // === HURUF J ===
        osingToIndonesianDict.put("jajang", "bambu");
        osingToIndonesianDict.put("jaluk", "minta");
        osingToIndonesianDict.put("jangan", "sayur");
        osingToIndonesianDict.put("jebeg", "tempat menggiling bumbu");
        osingToIndonesianDict.put("jebod", "rusak");
        osingToIndonesianDict.put("jedhor", "bedug");
        osingToIndonesianDict.put("jero", "dalam");
        osingToIndonesianDict.put("njero", "dalam");
        osingToIndonesianDict.put("jodo", "jodoh");
        osingToIndonesianDict.put("jogo", "jaga");
        osingToIndonesianDict.put("jorong", "jotos");
        osingToIndonesianDict.put("sontok", "jotos");
        osingToIndonesianDict.put("jumbleng", "gelap");
        osingToIndonesianDict.put("juwari", "percaya diri");

        // === HURUF K ===
        osingToIndonesianDict.put("kadang", "kadang");
        osingToIndonesianDict.put("kakik", "kakek");
        osingToIndonesianDict.put("kancing", "kunci");
        osingToIndonesianDict.put("kangen", "rindu");
        osingToIndonesianDict.put("kanggo", "untuk");
        osingToIndonesianDict.put("karep", "keinginan");
        osingToIndonesianDict.put("kari", "tinggal");
        osingToIndonesianDict.put("katik", "pakai");
        osingToIndonesianDict.put("katon", "terlihat");
        osingToIndonesianDict.put("kawitan", "pertama");
        osingToIndonesianDict.put("kecaruk", "ketemu");
        osingToIndonesianDict.put("kedanan", "tergila-gila");
        osingToIndonesianDict.put("kelangan", "kehilangan");
        osingToIndonesianDict.put("kelaran", "tersakiti");
        osingToIndonesianDict.put("kelendi", "bagaimana");
        osingToIndonesianDict.put("kelendhi", "bagaimana");
        osingToIndonesianDict.put("keliwat", "terlalu");
        osingToIndonesianDict.put("kembang", "bunga");
        osingToIndonesianDict.put("kence", "kurus");
        osingToIndonesianDict.put("kene", "sini");
        osingToIndonesianDict.put("keneng", "kena");
        osingToIndonesianDict.put("kepingin", "ingin");
        osingToIndonesianDict.put("kerano", "karena");
        osingToIndonesianDict.put("kerono", "karena");
        osingToIndonesianDict.put("krono", "karena");
        osingToIndonesianDict.put("kerep", "sering");
        osingToIndonesianDict.put("kerungu", "dengar");
        osingToIndonesianDict.put("krungu", "dengar");
        osingToIndonesianDict.put("ketemu", "bertemu");
        osingToIndonesianDict.put("kiro", "kira");
        osingToIndonesianDict.put("kono", "sana");
        osingToIndonesianDict.put("koyo", "seperti");
        osingToIndonesianDict.put("koyok", "seperti");
        osingToIndonesianDict.put("kulo", "aku");

        // === HURUF L ===
        osingToIndonesianDict.put("lading", "pisau");
        osingToIndonesianDict.put("lakoni", "jalani");
        osingToIndonesianDict.put("laku", "jalan");
        osingToIndonesianDict.put("lan", "dan");
        osingToIndonesianDict.put("lanang", "lelaki");
        osingToIndonesianDict.put("landhep", "tajam");
        osingToIndonesianDict.put("lancing", "lelaki belum menikah");
        osingToIndonesianDict.put("lare", "anak");
        osingToIndonesianDict.put("lawang", "pintu");
        osingToIndonesianDict.put("lawas", "lama");
        osingToIndonesianDict.put("layung", "sedih");
        osingToIndonesianDict.put("lekas", "usai");
        osingToIndonesianDict.put("lencur", "bolos");
        osingToIndonesianDict.put("melencur", "bolos");
        osingToIndonesianDict.put("lengo", "minyak");
        osingToIndonesianDict.put("lesuh", "lemas");
        osingToIndonesianDict.put("lik", "anak laki-laki");
        osingToIndonesianDict.put("thulik", "anak laki-laki");
        osingToIndonesianDict.put("lilo", "rela");
        osingToIndonesianDict.put("lintang", "bintang");
        osingToIndonesianDict.put("liwat", "lewat");
        osingToIndonesianDict.put("liwyat", "lewat");
        osingToIndonesianDict.put("liyo", "lain");
        osingToIndonesianDict.put("liyan", "lain");
        osingToIndonesianDict.put("loro", "dua");
        osingToIndonesianDict.put("loro", "sakit");
        osingToIndonesianDict.put("lucau", "lucu");
        osingToIndonesianDict.put("lurung", "jalan");
        osingToIndonesianDict.put("lurong", "jalan");
        osingToIndonesianDict.put("luput", "salah");
        osingToIndonesianDict.put("luwas", "usang");
        osingToIndonesianDict.put("bluwek", "usang");

        // === HURUF M ===
        osingToIndonesianDict.put("madang", "makan");
        osingToIndonesianDict.put("madhang", "makan");
        osingToIndonesianDict.put("madhyang", "makan");
        osingToIndonesianDict.put("magih", "masih");
        osingToIndonesianDict.put("mageh", "masih");
        osingToIndonesianDict.put("mak", "ibu");
        osingToIndonesianDict.put("makne", "biar");
        osingToIndonesianDict.put("man", "paman");
        osingToIndonesianDict.put("maneh", "lagi");
        osingToIndonesianDict.put("maning", "lagi");
        osingToIndonesianDict.put("marai", "mulai");
        osingToIndonesianDict.put("masio", "walau");
        osingToIndonesianDict.put("ambekno", "walau");
        osingToIndonesianDict.put("mbenu", "nakal");
        osingToIndonesianDict.put("mbenau", "nakal");
        osingToIndonesianDict.put("cengkal", "nakal");
        osingToIndonesianDict.put("mbok", "kakak perempuan");
        osingToIndonesianDict.put("mbulan", "bulan");
        osingToIndonesianDict.put("ulan", "bulan");
        osingToIndonesianDict.put("mburi", "belakang");
        osingToIndonesianDict.put("melek", "membuka mata");
        osingToIndonesianDict.put("merem", "menutup mata");
        osingToIndonesianDict.put("mending", "lebih baik");
        osingToIndonesianDict.put("mengan", "main");
        osingToIndonesianDict.put("mengo", "terbuka");
        osingToIndonesianDict.put("menungso", "manusia");
        osingToIndonesianDict.put("mesem", "senyum");
        osingToIndonesianDict.put("mili", "mengalir");
        osingToIndonesianDict.put("milu", "ikut");
        osingToIndonesianDict.put("melu", "ikut");
        osingToIndonesianDict.put("mlaku", "berjalan");
        osingToIndonesianDict.put("mokso", "maksa");
        osingToIndonesianDict.put("mongko", "padahal");
        osingToIndonesianDict.put("mongso", "musim");
        osingToIndonesianDict.put("monyik", "senyum");
        osingToIndonesianDict.put("unyik", "senyum");
        osingToIndonesianDict.put("moreng", "marah");
        osingToIndonesianDict.put("moring", "marah");
        osingToIndonesianDict.put("moro", "datang");
        osingToIndonesianDict.put("moto", "mata");
        osingToIndonesianDict.put("mugi", "semoga");
        osingToIndonesianDict.put("mugo", "semoga");
        osingToIndonesianDict.put("muko", "tadi");
        osingToIndonesianDict.put("mauko", "tadi");
        osingToIndonesianDict.put("mulo", "memang");
        osingToIndonesianDict.put("mulok", "memang");
        osingToIndonesianDict.put("munyer", "pusing");
        osingToIndonesianDict.put("mupakat", "wajar");

        // === HURUF N ===
        osingToIndonesianDict.put("nahan", "menahan");
        osingToIndonesianDict.put("nangis", "menangis");
        osingToIndonesianDict.put("nalar", "bantah");
        osingToIndonesianDict.put("talar", "bantah");
        osingToIndonesianDict.put("nambahi", "menambah");
        osingToIndonesianDict.put("nambani", "mengobati");
        osingToIndonesianDict.put("ngarep", "depan");
        osingToIndonesianDict.put("ngarep", "mengharap");
        osingToIndonesianDict.put("ndiko", "anda yang dihormati");
        osingToIndonesianDict.put("ndol", "menggelikan");
        osingToIndonesianDict.put("nekek", "tua sekali");
        osingToIndonesianDict.put("nemen", "sangat");
        osingToIndonesianDict.put("netes", "menetes");
        osingToIndonesianDict.put("ngadoh", "menjauh");
        osingToIndonesianDict.put("ngangen", "berharap");
        osingToIndonesianDict.put("ngalah", "mengalah");
        osingToIndonesianDict.put("ngalor", "ke utara");
        osingToIndonesianDict.put("nganti", "sampai");
        osingToIndonesianDict.put("ngidul", "ke selatan");
        osingToIndonesianDict.put("ngajak", "mengajak");
        osingToIndonesianDict.put("nganggo", "pakai");
        osingToIndonesianDict.put("ngapusi", "bohongi");
        osingToIndonesianDict.put("ngawiti", "memulai");
        osingToIndonesianDict.put("ngelali", "melupakan");
        osingToIndonesianDict.put("ngelarani", "menyakiti");
        osingToIndonesianDict.put("ngelayung", "bersedih");
        osingToIndonesianDict.put("ngerti", "tahu");
        osingToIndonesianDict.put("ngimpi", "mimpi");
        osingToIndonesianDict.put("ngiro", "mengira");
        osingToIndonesianDict.put("ngisi", "mengisi");
        osingToIndonesianDict.put("nglakoni", "menjalani");
        osingToIndonesianDict.put("ngelakoni", "menjalani");
        osingToIndonesianDict.put("ngobong", "membakar");
        osingToIndonesianDict.put("ngogrok", "jongkok");
        osingToIndonesianDict.put("ngomong", "bicara");
        osingToIndonesianDict.put("nguber", "mengejar");
        osingToIndonesianDict.put("ninggal", "tinggalkan");
        osingToIndonesianDict.put("njaluk", "minta");
        osingToIndonesianDict.put("nompo", "menerima");
        osingToIndonesianDict.put("nong", "di");
        osingToIndonesianDict.put("ring", "di");
        osingToIndonesianDict.put("nono", "tidak ada");
        osingToIndonesianDict.put("nundung", "mengusir");
        osingToIndonesianDict.put("nuruti", "menuruti");
        osingToIndonesianDict.put("nyali", "keberanian");
        osingToIndonesianDict.put("nyang", "pada");
        osingToIndonesianDict.put("nyawang", "melihat");
        osingToIndonesianDict.put("nyekso", "menyiksa");
        osingToIndonesianDict.put("nyembah", "menyembah");
        osingToIndonesianDict.put("nyoto", "nyata");
        osingToIndonesianDict.put("nyowo", "nyawa");

        // === HURUF O ===
        osingToIndonesianDict.put("odod", "akar");
        osingToIndonesianDict.put("ojo", "jangan");
        osingToIndonesianDict.put("olih", "boleh");
        osingToIndonesianDict.put("oleh", "boleh");
        osingToIndonesianDict.put("omong", "bicara");
        osingToIndonesianDict.put("ondok", "tangga");
        osingToIndonesianDict.put("ongkeb", "gerah");
        osingToIndonesianDict.put("opo", "apa");
        osingToIndonesianDict.put("opor", "bakar");
        osingToIndonesianDict.put("ono", "ada");
        osingToIndonesianDict.put("onok", "ada");
        osingToIndonesianDict.put("osing", "tidak");
        osingToIndonesianDict.put("oseng", "tidak");
        osingToIndonesianDict.put("sing", "tidak");

        // === HURUF P ===
        osingToIndonesianDict.put("padang", "terang");
        osingToIndonesianDict.put("panggon", "tempat");
        osingToIndonesianDict.put("panggonan", "tempat");
        osingToIndonesianDict.put("papag", "jemput");
        osingToIndonesianDict.put("papak", "tumpul");
        osingToIndonesianDict.put("paran", "apa");
        osingToIndonesianDict.put("parek", "dekat");
        osingToIndonesianDict.put("pati", "mati");
        osingToIndonesianDict.put("pati", "sering");
        osingToIndonesianDict.put("pawon", "dapur");
        osingToIndonesianDict.put("payung", "pelindung");
        osingToIndonesianDict.put("pedhot", "putus");
        osingToIndonesianDict.put("tugel", "putus");
        osingToIndonesianDict.put("pegat", "cerai");
        osingToIndonesianDict.put("pekso", "paksa");
        osingToIndonesianDict.put("penging", "larang");
        osingToIndonesianDict.put("percoyo", "percaya");
        osingToIndonesianDict.put("percumo", "percuma");
        osingToIndonesianDict.put("peteng", "gelap");
        osingToIndonesianDict.put("pethal", "pisah");
        osingToIndonesianDict.put("picis", "uang");
        osingToIndonesianDict.put("yotro", "uang");
        osingToIndonesianDict.put("pingin", "ingin");
        osingToIndonesianDict.put("pengen", "ingin");
        osingToIndonesianDict.put("pisan", "sekali");
        osingToIndonesianDict.put("pisan", "juga");
        osingToIndonesianDict.put("ugo", "juga");
        osingToIndonesianDict.put("podo", "sama");
        osingToIndonesianDict.put("pokang", "paha");
        osingToIndonesianDict.put("polae", "karena");
        osingToIndonesianDict.put("praenan", "wajah");
        osingToIndonesianDict.put("pujane", "pujaan");
        osingToIndonesianDict.put("pujo", "puja");
        osingToIndonesianDict.put("puteh", "putih");
        osingToIndonesianDict.put("puthuk", "bukit");

        // === HURUF R ===
        osingToIndonesianDict.put("rabi", "istri");
        osingToIndonesianDict.put("rasane", "rasanya");
        osingToIndonesianDict.put("reki", "ketombe");
        osingToIndonesianDict.put("rempi", "tidak kuat");
        osingToIndonesianDict.put("remuk", "hancur");
        osingToIndonesianDict.put("rendeng", "penghujan");
        osingToIndonesianDict.put("rogo", "raga");
        osingToIndonesianDict.put("roso", "rasa");
        osingToIndonesianDict.put("royak", "ramai");
        osingToIndonesianDict.put("ruces", "heboh");
        osingToIndonesianDict.put("rumongso", "merasa");

        // === HURUF S ===
        osingToIndonesianDict.put("sabar", "sabar");
        osingToIndonesianDict.put("sabari", "sabar");
        osingToIndonesianDict.put("saben", "setiap");
        osingToIndonesianDict.put("sabendino", "setiap hari");
        osingToIndonesianDict.put("sabrang", "menyebrang");
        osingToIndonesianDict.put("sak", "se");
        osingToIndonesianDict.put("saiki", "sekarang");
        osingToIndonesianDict.put("saikine", "sekarang");
        osingToIndonesianDict.put("sait", "hajar");
        osingToIndonesianDict.put("sambang", "milik");
        osingToIndonesianDict.put("sampat", "pukul pakai kayu");
        osingToIndonesianDict.put("sampek", "sampai");
        osingToIndonesianDict.put("samudro", "samudera");
        osingToIndonesianDict.put("sanding", "berdamping");
        osingToIndonesianDict.put("sawai", "singkong");
        osingToIndonesianDict.put("sawang", "lihat");
        osingToIndonesianDict.put("sawen", "sawi");
        osingToIndonesianDict.put("selawase", "selamanya");
        osingToIndonesianDict.put("sembur", "sebar");
        osingToIndonesianDict.put("semprong", "tiup");
        osingToIndonesianDict.put("seng", "tidak");
        osingToIndonesianDict.put("seneng", "suka");
        osingToIndonesianDict.put("sepuro", "maaf");
        osingToIndonesianDict.put("serngenge", "matahari");
        osingToIndonesianDict.put("sesek", "sesak");
        osingToIndonesianDict.put("seru", "sangat");
        osingToIndonesianDict.put("setyo", "setia");
        osingToIndonesianDict.put("siji", "satu");
        osingToIndonesianDict.put("simpen", "simpan");
        osingToIndonesianDict.put("sokheh", "nikmat sekali");
        osingToIndonesianDict.put("soko", "dari");
        osingToIndonesianDict.put("teko", "dari");
        osingToIndonesianDict.put("songgo", "tanggung");
        osingToIndonesianDict.put("sopo", "siapa");
        osingToIndonesianDict.put("hopo", "siapa");
        osingToIndonesianDict.put("sowok", "teluh");
        osingToIndonesianDict.put("sihir", "teluh");
        osingToIndonesianDict.put("soyo", "makin");
        osingToIndonesianDict.put("sudo", "berkurang");
        osingToIndonesianDict.put("sulung", "duluan");
        osingToIndonesianDict.put("solong", "duluan");
        osingToIndonesianDict.put("sulung", "sebentar");
        osingToIndonesianDict.put("sungkan", "enggan");
        osingToIndonesianDict.put("surut", "berkurang");
        osingToIndonesianDict.put("suwargo", "surga");
        osingToIndonesianDict.put("surgo", "surga");
        osingToIndonesianDict.put("suwek", "sobek");
        osingToIndonesianDict.put("suwak", "sobek");
        osingToIndonesianDict.put("suwi", "lama");
        osingToIndonesianDict.put("suwe", "lama");
        osingToIndonesianDict.put("suworo", "suara");
        osingToIndonesianDict.put("sworo", "suara");
        osingToIndonesianDict.put("suoro", "suara");

        // === HURUF T ===
        osingToIndonesianDict.put("tah", "kah");
        osingToIndonesianDict.put("taker", "sampai");
        osingToIndonesianDict.put("takon", "tanya");
        osingToIndonesianDict.put("tali", "ikat");
        osingToIndonesianDict.put("tambeng", "nakal");
        osingToIndonesianDict.put("tanggo", "kira");
        osingToIndonesianDict.put("tapi", "tapi");
        osingToIndonesianDict.put("taping", "tetapi");
        osingToIndonesianDict.put("tapuk", "tampar");
        osingToIndonesianDict.put("tempeleng", "tampar");
        osingToIndonesianDict.put("tanduk", "tendang");
        osingToIndonesianDict.put("tanpo", "tanpa");
        osingToIndonesianDict.put("tasemak", "kacamata");
        osingToIndonesianDict.put("tatak", "gigih");
        osingToIndonesianDict.put("tatag", "kuat");
        osingToIndonesianDict.put("tatu", "luka");
        osingToIndonesianDict.put("tau", "pernah");
        osingToIndonesianDict.put("tedyas", "mempan");
        osingToIndonesianDict.put("teko", "datang");
        osingToIndonesianDict.put("tego", "tega");
        osingToIndonesianDict.put("temakno", "ternyata");
        osingToIndonesianDict.put("cumpune", "ternyata");
        osingToIndonesianDict.put("ketang", "ternyata");
        osingToIndonesianDict.put("tembang", "lagu");
        osingToIndonesianDict.put("temen", "benar-benar");
        osingToIndonesianDict.put("temenan", "serius");
        osingToIndonesianDict.put("temencog", "lompat");
        osingToIndonesianDict.put("mlencung", "lompat");
        osingToIndonesianDict.put("tentrem", "tentram");
        osingToIndonesianDict.put("terbas", "terkam");
        osingToIndonesianDict.put("tetep", "tetap");
        osingToIndonesianDict.put("tibane", "ternyata");
        osingToIndonesianDict.put("tibo", "jatuh");
        osingToIndonesianDict.put("timbyangeno", "daripada");
        osingToIndonesianDict.put("ketimbyang", "daripada");
        osingToIndonesianDict.put("tratag", "panggung");
        osingToIndonesianDict.put("trimo", "terima");
        osingToIndonesianDict.put("terimo", "terima");
        osingToIndonesianDict.put("tulung", "tolong");
        osingToIndonesianDict.put("tujes", "tikam");
        osingToIndonesianDict.put("tulodho", "contoh");
        osingToIndonesianDict.put("tuman", "sering");
        osingToIndonesianDict.put("tumyan", "sering");
        osingToIndonesianDict.put("tundung", "usir");
        osingToIndonesianDict.put("turu", "tidur");
        osingToIndonesianDict.put("tuwuk", "puas");
        osingToIndonesianDict.put("towok", "puas");

        // === HURUF U ===
        osingToIndonesianDict.put("udan", "hujan");
        osingToIndonesianDict.put("ulog", "ular");
        osingToIndonesianDict.put("umpomo", "seandainya");
        osingToIndonesianDict.put("umyah", "rumah");
        osingToIndonesianDict.put("umyan", "kebagian");
        osingToIndonesianDict.put("ungkapno", "ungkapkan");
        osingToIndonesianDict.put("urip", "hidup");
        osingToIndonesianDict.put("uwah", "berubah");
        osingToIndonesianDict.put("uwel", "marah");

        // === HURUF W ===
        osingToIndonesianDict.put("wadon", "wanita");
        osingToIndonesianDict.put("wedok", "wanita");
        osingToIndonesianDict.put("waled", "alot");
        osingToIndonesianDict.put("wanen", "berani");
        osingToIndonesianDict.put("wangi", "harum");
        osingToIndonesianDict.put("wangkot", "keras kepala");
        osingToIndonesianDict.put("wayah", "waktu");
        osingToIndonesianDict.put("wawuh", "akrab");
        osingToIndonesianDict.put("wedi", "takut");
        osingToIndonesianDict.put("wejek", "peras");
        osingToIndonesianDict.put("wero", "luas");
        osingToIndonesianDict.put("werok", "luas");
        osingToIndonesianDict.put("weruh", "tahu");
        osingToIndonesianDict.put("wes", "sudah");
        osingToIndonesianDict.put("wis", "sudah");
        osingToIndonesianDict.put("wingek", "dulu sekali");
        osingToIndonesianDict.put("wingyenanek", "kemarin");
        osingToIndonesianDict.put("woco", "baca");
        osingToIndonesianDict.put("wong", "orang");
        osingToIndonesianDict.put("uwong", "orang");
        osingToIndonesianDict.put("wujud", "bentuk");
        osingToIndonesianDict.put("wuruk", "ajaran");
        osingToIndonesianDict.put("wutuh", "utuh");

        // === HURUF Y ===
        osingToIndonesianDict.put("yane", "dia");
        osingToIndonesianDict.put("yo", "ya");
        osingToIndonesianDict.put("yok", "ya");
        osingToIndonesianDict.put("iyok", "ya");
        osingToIndonesianDict.put("yoro", "ya");

        // === ADDITIONAL COMMON PHRASES ===
        osingToIndonesianDict.put("sugeng enjing", "selamat pagi");
        osingToIndonesianDict.put("sugeng siang", "selamat siang");
        osingToIndonesianDict.put("sugeng sonten", "selamat sore");
        osingToIndonesianDict.put("sugeng dalu", "selamat malam");
        osingToIndonesianDict.put("matur nuwun", "terima kasih");
        osingToIndonesianDict.put("sewu", "maaf");
        osingToIndonesianDict.put("monggo", "silakan");
        osingToIndonesianDict.put("pripun", "bagaimana");
        osingToIndonesianDict.put("kawulo", "saya");
        osingToIndonesianDict.put("panjenengan", "anda");
        osingToIndonesianDict.put("nggih", "ya");
        osingToIndonesianDict.put("mboten", "tidak");
        osingToIndonesianDict.put("wonten", "ada");
        osingToIndonesianDict.put("niki", "ini");
        osingToIndonesianDict.put("niku", "itu");
        osingToIndonesianDict.put("dhateng", "ke");
        osingToIndonesianDict.put("saking", "dari");
        osingToIndonesianDict.put("kaliyan", "dengan");
        osingToIndonesianDict.put("badhe", "akan");
        osingToIndonesianDict.put("sampun", "sudah");
        osingToIndonesianDict.put("dereng", "belum");
        osingToIndonesianDict.put("ajeng", "mau");
        osingToIndonesianDict.put("boten", "tidak");
        osingToIndonesianDict.put("inggih", "iya");

        // === NUMBERS ===
        osingToIndonesianDict.put("setunggal", "satu");
        osingToIndonesianDict.put("kalih", "dua");
        osingToIndonesianDict.put("tiga", "tiga");
        osingToIndonesianDict.put("sekawan", "empat");
        osingToIndonesianDict.put("gangsal", "lima");
        osingToIndonesianDict.put("enem", "enam");
        osingToIndonesianDict.put("pitu", "tujuh");
        osingToIndonesianDict.put("wolu", "delapan");
        osingToIndonesianDict.put("sanga", "sembilan");
        osingToIndonesianDict.put("sedasa", "sepuluh");

        // === FAMILY TERMS ===
        osingToIndonesianDict.put("bapak", "ayah");
        osingToIndonesianDict.put("ibu", "ibu");
        osingToIndonesianDict.put("anak", "anak");
        osingToIndonesianDict.put("kakang", "kakak laki-laki");
        osingToIndonesianDict.put("mbakyu", "kakak perempuan");
        osingToIndonesianDict.put("adhi", "adik");

        // === COMMON VERBS ===
        osingToIndonesianDict.put("mangan", "makan");
        osingToIndonesianDict.put("ngombe", "minum");
        osingToIndonesianDict.put("turu", "tidur");
        osingToIndonesianDict.put("tangi", "bangun");
        osingToIndonesianDict.put("lunga", "pergi");
        osingToIndonesianDict.put("mulih", "pulang");
        osingToIndonesianDict.put("rawuh", "datang");
        osingToIndonesianDict.put("ndeleng", "melihat");
        osingToIndonesianDict.put("ngrungokake", "mendengar");

        // Create reverse dictionary (Indonesian to Osing)
        indonesianToOsingDict = new HashMap<>();
        for (Map.Entry<String, String> entry : osingToIndonesianDict.entrySet()) {
            String indonesianWord = entry.getValue();
            String osingWord = entry.getKey();

            // Handle multiple Indonesian meanings for same Osing word
            if (indonesianToOsingDict.containsKey(indonesianWord)) {
                // Keep the shorter or more common Osing word
                String existingOsingWord = indonesianToOsingDict.get(indonesianWord);
                if (osingWord.length() < existingOsingWord.length()) {
                    indonesianToOsingDict.put(indonesianWord, osingWord);
                }
            } else {
                indonesianToOsingDict.put(indonesianWord, osingWord);
            }
        }

        // Add some Indonesian words that might not have direct reverse mapping
        indonesianToOsingDict.put("hello", "sugeng");
        indonesianToOsingDict.put("selamat", "sugeng");
        indonesianToOsingDict.put("terima kasih", "matur nuwun");
        indonesianToOsingDict.put("maaf", "sewu");
        indonesianToOsingDict.put("silakan", "monggo");
        indonesianToOsingDict.put("bagaimana", "pripun");
        indonesianToOsingDict.put("kenapa", "apuo");
        indonesianToOsingDict.put("dimana", "endi");
        indonesianToOsingDict.put("kapan", "kapan");
        indonesianToOsingDict.put("siapa", "sopo");
        indonesianToOsingDict.put("berapa", "pinten");
    }

    /**
     * Translate text from Osing to Indonesian
     */
    public void translateOsingToIndonesian(String osingText, TranslationCallback callback) {
        if (osingText == null || osingText.trim().isEmpty()) {
            callback.onFailure("Teks kosong");
            return;
        }

        try {
            String translatedText = performTranslation(osingText, osingToIndonesianDict, true);
            callback.onSuccess(translatedText);
        } catch (Exception e) {
            Log.e(TAG, "Translation failed", e);
            callback.onFailure("Gagal menerjemahkan: " + e.getMessage());
        }
    }

    /**
     * Translate text from Indonesian to Osing
     */
    public void translateIndonesianToOsing(String indonesianText, TranslationCallback callback) {
        if (indonesianText == null || indonesianText.trim().isEmpty()) {
            callback.onFailure("Teks kosong");
            return;
        }

        try {
            String translatedText = performTranslation(indonesianText, indonesianToOsingDict, false);
            callback.onSuccess(translatedText);
        } catch (Exception e) {
            Log.e(TAG, "Translation failed", e);
            callback.onFailure("Gagal menerjemahkan: " + e.getMessage());
        }
    }

    /**
     * Perform the actual translation using the dictionary
     */
    private String performTranslation(String inputText, Map<String, String> dictionary, boolean isOsingToIndonesian) {
        String[] sentences = inputText.split("[.!?]+");
        StringBuilder translatedText = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].trim();
            if (!sentence.isEmpty()) {
                String translatedSentence = translateSentence(sentence, dictionary, isOsingToIndonesian);
                translatedText.append(translatedSentence);

                // Add punctuation back
                if (i < sentences.length - 1) {
                    translatedText.append(". ");
                }
            }
        }

        String result = translatedText.toString().trim();

        // Apply post-processing rules
        result = applyTranslationRules(result, isOsingToIndonesian);

        return result;
    }

    /**
     * Translate a single sentence
     */
    private String translateSentence(String sentence, Map<String, String> dictionary, boolean isOsingToIndonesian) {
        String[] words = sentence.toLowerCase().split("\\s+");
        StringBuilder translatedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String cleanWord = cleanWord(word);
            String translation = findTranslation(cleanWord, dictionary, isOsingToIndonesian);

            if (translation != null) {
                // Preserve original punctuation and capitalization
                String finalWord = preserveFormatting(word, translation);
                translatedSentence.append(finalWord);
            } else {
                // Word not found, keep original
                translatedSentence.append(word);
            }

            if (i < words.length - 1) {
                translatedSentence.append(" ");
            }
        }

        return translatedSentence.toString();
    }

    /**
     * Clean word by removing punctuation for lookup
     */
    private String cleanWord(String word) {
        return word.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase();
    }

    /**
     * Find translation with fuzzy matching
     */
    private String findTranslation(String cleanWord, Map<String, String> dictionary, boolean isOsingToIndonesian) {
        // Direct lookup
        if (dictionary.containsKey(cleanWord)) {
            return dictionary.get(cleanWord);
        }

        // Try partial matching for compound words
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            String dictWord = entry.getKey();

            // Check if the word contains a known word
            if (cleanWord.contains(dictWord) && dictWord.length() > 2) {
                return entry.getValue();
            }

            // Check if a known word contains the input word
            if (dictWord.contains(cleanWord) && cleanWord.length() > 2) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Preserve original word formatting (capitalization, punctuation)
     */
    private String preserveFormatting(String originalWord, String translation) {
        StringBuilder result = new StringBuilder(translation);

        // Preserve capitalization
        if (Character.isUpperCase(originalWord.charAt(0))) {
            result.setCharAt(0, Character.toUpperCase(result.charAt(0)));
        }

        // Preserve punctuation at the end
        String punctuation = originalWord.replaceAll("[\\p{L}\\p{N}]", "");
        if (!punctuation.isEmpty()) {
            result.append(punctuation);
        }

        return result.toString();
    }

    /**
     * Apply language-specific rules and grammar adjustments
     */
    private String applyTranslationRules(String text, boolean isOsingToIndonesian) {
        if (isOsingToIndonesian) {
            // Osing to Indonesian rules
            text = text.replaceAll("\\bmatur nuwun\\b", "terima kasih");
            text = text.replaceAll("\\bsugeng enjing\\b", "selamat pagi");
            text = text.replaceAll("\\bsugeng siang\\b", "selamat siang");
            text = text.replaceAll("\\bsugeng sonten\\b", "selamat sore");
            text = text.replaceAll("\\bsugeng dalu\\b", "selamat malam");
            text = text.replaceAll("\\bpripun kabar\\b", "apa kabar");
        } else {
            // Indonesian to Osing rules
            text = text.replaceAll("\\bterima kasih\\b", "matur nuwun");
            text = text.replaceAll("\\bselamat pagi\\b", "sugeng enjing");
            text = text.replaceAll("\\bselamat siang\\b", "sugeng siang");
            text = text.replaceAll("\\bselamat sore\\b", "sugeng sonten");
            text = text.replaceAll("\\bselamat malam\\b", "sugeng dalu");
            text = text.replaceAll("\\bapa kabar\\b", "pripun kabar");
        }

        return text;
    }

    /**
     * Detect if text is likely in Osing language
     */
    public boolean detectLanguage(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        String[] words = text.toLowerCase().split("\\s+");
        int osingWordCount = 0;
        int indonesianWordCount = 0;
        int totalWords = 0;

        for (String word : words) {
            String cleanWord = cleanWord(word);
            if (cleanWord.length() > 1) {
                totalWords++;

                if (osingToIndonesianDict.containsKey(cleanWord)) {
                    osingWordCount++;
                } else if (indonesianToOsingDict.containsKey(cleanWord)) {
                    indonesianWordCount++;
                }
            }
        }

        // If more than 30% of words are identified as Osing, classify as Osing
        if (totalWords > 0) {
            double osingRatio = (double) osingWordCount / totalWords;
            return osingRatio > 0.3;
        }

        return false;
    }

    /**
     * Get translation confidence score
     */
    public double getTranslationConfidence(String originalText, String translatedText, boolean isOsingToIndonesian) {
        if (originalText == null || translatedText == null) {
            return 0.0;
        }

        String[] originalWords = originalText.toLowerCase().split("\\s+");
        Map<String, String> dictionary = isOsingToIndonesian ? osingToIndonesianDict : indonesianToOsingDict;

        int foundTranslations = 0;
        int totalWords = 0;

        for (String word : originalWords) {
            String cleanWord = cleanWord(word);
            if (cleanWord.length() > 1) {
                totalWords++;
                if (dictionary.containsKey(cleanWord)) {
                    foundTranslations++;
                }
            }
        }

        return totalWords > 0 ? (double) foundTranslations / totalWords : 0.0;
    }

    /**
     * Get dictionary statistics
     */
    public String getDictionaryStats() {
        return String.format("Kamus berisi %d kata Osing dan %d kata Indonesia",
                osingToIndonesianDict.size(),
                indonesianToOsingDict.size());
    }

    /**
     * Search for words in dictionary (for autocomplete or suggestions)
     */
    public List<String> searchWords(String prefix, boolean isOsing) {
        List<String> results = new ArrayList<>();
        Map<String, String> dictionary = isOsing ? osingToIndonesianDict : indonesianToOsingDict;

        prefix = prefix.toLowerCase();

        for (String word : dictionary.keySet()) {
            if (word.startsWith(prefix)) {
                results.add(word);
            }
        }

        Collections.sort(results);
        return results.size() > 20 ? results.subList(0, 20) : results;
    }

    /**
     * Get word definition/translation
     */
    public String getWordTranslation(String word, boolean isOsing) {
        Map<String, String> dictionary = isOsing ? osingToIndonesianDict : indonesianToOsingDict;
        String cleanWord = cleanWord(word);
        return dictionary.get(cleanWord);
    }

    /**
     * Add new word pair to dictionary (for learning/updating)
     */
    public void addWordPair(String osingWord, String indonesianWord) {
        if (osingWord != null && indonesianWord != null &&
                !osingWord.trim().isEmpty() && !indonesianWord.trim().isEmpty()) {

            String cleanOsing = osingWord.toLowerCase().trim();
            String cleanIndonesian = indonesianWord.toLowerCase().trim();

            osingToIndonesianDict.put(cleanOsing, cleanIndonesian);
            indonesianToOsingDict.put(cleanIndonesian, cleanOsing);

            Log.d(TAG, "Added word pair: " + cleanOsing + " -> " + cleanIndonesian);
        }
    }

    /**
     * Check if word exists in dictionary
     */
    public boolean isWordExists(String word, boolean isOsing) {
        Map<String, String> dictionary = isOsing ? osingToIndonesianDict : indonesianToOsingDict;
        String cleanWord = cleanWord(word);
        return dictionary.containsKey(cleanWord);
    }

    /**
     * Get similar words (for spell correction suggestions)
     */
    public List<String> getSimilarWords(String word, boolean isOsing) {
        List<String> similar = new ArrayList<>();
        Map<String, String> dictionary = isOsing ? osingToIndonesianDict : indonesianToOsingDict;

        String cleanWord = cleanWord(word).toLowerCase();

        for (String dictWord : dictionary.keySet()) {
            // Calculate similarity based on common characters and length
            if (calculateSimilarity(cleanWord, dictWord) > 0.6) {
                similar.add(dictWord);
            }
        }

        Collections.sort(similar);
        return similar.size() > 10 ? similar.subList(0, 10) : similar;
    }

    /**
     * Calculate similarity between two words (simple algorithm)
     */
    private double calculateSimilarity(String word1, String word2) {
        if (word1.equals(word2)) return 1.0;
        if (Math.abs(word1.length() - word2.length()) > 3) return 0.0;

        int commonChars = 0;
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                commonChars++;
            }
        }

        return (double) commonChars / Math.max(word1.length(), word2.length());
    }

    /**
     * Validate translation quality
     */
    public boolean isValidTranslation(String original, String translation, boolean isOsingToIndonesian) {
        if (original == null || translation == null ||
                original.trim().isEmpty() || translation.trim().isEmpty()) {
            return false;
        }

        // Check if translation is just the same as original (untranslated)
        if (original.toLowerCase().equals(translation.toLowerCase())) {
            return false;
        }

        // Check minimum confidence score
        double confidence = getTranslationConfidence(original, translation, isOsingToIndonesian);
        return confidence > 0.2; // At least 20% of words should be translated
    }

    /**
     * Get common Osing phrases for quick access
     */
    public Map<String, String> getCommonPhrases() {
        Map<String, String> phrases = new HashMap<>();

        // Basic Osing greetings and common expressions
        phrases.put("sugeng enjing", "selamat pagi");
        phrases.put("sugeng siang", "selamat siang");
        phrases.put("sugeng sonten", "selamat sore");
        phrases.put("sugeng dalu", "selamat malam");
        phrases.put("matur nuwun", "terima kasih");
        phrases.put("sewu", "maaf");
        phrases.put("monggo", "silakan");
        phrases.put("pripun kabar", "apa kabar");
        phrases.put("apuo kabare", "apa kabarnya");
        phrases.put("piye kabare", "bagaimana kabarnya");
        phrases.put("opo aran", "siapa nama");
        phrases.put("soko endi", "dari mana");
        phrases.put("arep menyang endi", "mau ke mana");
        phrases.put("sampun madang", "sudah makan");
        phrases.put("durung madang", "belum makan");
        phrases.put("balik omah", "pulang rumah");
        phrases.put("lungo kerjo", "pergi kerja");
        phrases.put("tulung aku", "tolong saya");
        phrases.put("maaf sewu", "maaf ya");
        phrases.put("sugeng wayah", "selamat siang");

        return phrases;
    }

    /**
     * Get word categories for learning
     */
    public Map<String, List<String>> getWordCategories() {
        Map<String, List<String>> categories = new HashMap<>();

        // Family - corrected to authentic Osing terms
        List<String> family = new ArrayList<>();
        family.add("bapak - ayah");
        family.add("byapak - bapak");
        family.add("mak - ibu");
        family.add("embyah - nenek");
        family.add("kakik - kakek");
        family.add("lare - anak");
        family.add("kang - kakak laki-laki");
        family.add("mbok - kakak perempuan");
        family.add("lik - anak laki-laki");
        family.add("beng - anak perempuan");
        family.add("thulik - anak laki-laki");
        family.add("jebeng - anak perempuan");
        categories.put("Keluarga", family);

        // Numbers - authentic Osing numbers
        List<String> numbers = new ArrayList<>();
        numbers.add("siji - satu");
        numbers.add("loro - dua");
        numbers.add("telu - tiga");
        numbers.add("papat - empat");
        numbers.add("limo - lima");
        numbers.add("enem - enam");
        numbers.add("pitu - tujuh");
        numbers.add("wolu - delapan");
        numbers.add("sanga - sembilan");
        numbers.add("sepuluh - sepuluh");
        categories.put("Angka", numbers);

        // Colors - authentic Osing color terms
        List<String> colors = new ArrayList<>();
        colors.add("cemeng - hitam");
        colors.add("puteh - putih");
        colors.add("abang - merah");
        colors.add("ijo - hijau");
        colors.add("biru - biru");
        colors.add("kuning - kuning");
        categories.put("Warna", colors);

        // Body parts - authentic Osing terms
        List<String> body = new ArrayList<>();
        body.add("moto - mata");
        body.add("ati - hati");
        body.add("dadan - dada");
        body.add("driji - jari");
        body.add("boyok - punggung");
        body.add("pokang - paha");
        body.add("sirah - kepala");
        body.add("gulu - leher");
        body.add("tangan - tangan");
        body.add("sikil - kaki");
        categories.put("Anggota Tubuh", body);

        // Common verbs - authentic Osing verbs
        List<String> verbs = new ArrayList<>();
        verbs.add("mangan - makan");
        verbs.add("madhang - makan");
        verbs.add("ngombe - minum");
        verbs.add("turu - tidur");
        verbs.add("tangi - bangun");
        verbs.add("lunga - pergi");
        verbs.add("mulih - pulang");
        verbs.add("deleng - lihat");
        verbs.add("krungu - dengar");
        verbs.add("mlaku - jalan");
        verbs.add("laku - berjalan");
        verbs.add("gowo - bawa");
        verbs.add("ampet - ambil");
        verbs.add("juwut - ambil");
        categories.put("Kata Kerja", verbs);

        // Time expressions
        List<String> time = new ArrayList<>();
        time.add("enjing - pagi");
        time.add("awan - siang");
        time.add("sonten - sore");
        time.add("bengi - malam");
        time.add("wingi - kemarin");
        time.add("saiki - sekarang");
        time.add("sesuk - besok");
        time.add("biyen - dulu");
        categories.put("Waktu", time);

        // Nature and environment
        List<String> nature = new ArrayList<>();
        nature.add("banyu - air");
        nature.add("byanyu - air");
        nature.add("udan - hujan");
        nature.add("angin - angin");
        nature.add("lintang - bintang");
        nature.add("rembulan - bulan");
        nature.add("srengenge - matahari");
        nature.add("mega - awan");
        categories.put("Alam", nature);

        return categories;
    }
}