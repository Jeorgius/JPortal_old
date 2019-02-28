import {newsList} from "../content/interfaces/displayContent";

export class NewsItem implements newsList{

  public id :number;
  public picHTML :string;

  constructor(
    public newsTitle :string,
    public pic :File,
    public newsText :string
  ){}
}
