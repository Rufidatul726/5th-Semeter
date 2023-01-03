public class PageSaveMode extends PrintMode{    //refuse bequest

    @Override
    public void saveToner() {

    }

    @Override
    public void savePage() {
        int pageSize= this.getPage_size();
        String orientation= this.getOrientation();
        int numberOfPages = 0;

        //adjust page size and orientation
        //Reduce number of pages

        setNumber_of_pages(numberOfPages);
    }

    @Override
    public void boost() {

    }

    public void renderReview(){
        //Priview of Updated Document
    }

}
