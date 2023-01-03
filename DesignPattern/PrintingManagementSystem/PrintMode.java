import java.util.List;

public abstract class PrintMode {
    private int number_of_pages;
    private int page_size;
    private String orientation;
    private int color_intensity;
    private int cost_per_page;
    //primitive Obsession
    public abstract void saveToner();
    public abstract void savePage();
    public abstract void boost();

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        List<String>orientationType=List.of("Landscape", "Portrait");
        this.orientation = orientationType.get(0);
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getColor_intensity() {
        return color_intensity;
    }

    public void setColor_intensity(int color_intensity) {

        this.color_intensity = color_intensity;
    }

    public int getCost_per_page() {
        return cost_per_page;
    }

    public void setCost_per_page(int cost_per_page) {
        this.cost_per_page = cost_per_page;
    }
}
