import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class VacancyResponse {

    @SerializedName("found")
    @Expose
    int found;
    @SerializedName("pages")
    @Expose
    int pages;
    @SerializedName("items")
    @Expose
    List<Vacancy> items;
    @Expose
    @SerializedName("per_page")
    int perPage;
}
