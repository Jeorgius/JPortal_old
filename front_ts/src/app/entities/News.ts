import {newsList} from "../content/interfaces/displayContent";

export class NewsItem implements newsList{

  public id :number;
  public picHTML :string;
  public pic :File;

  constructor(
    public newsTitle :string,
    public newsText :string
  ){}
}
