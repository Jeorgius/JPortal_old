import {newsList} from "../content/interfaces/displayContent";

export class NewsItem implements newsList{
  public id :number;

  constructor(
    public newsTitle :string,
    public picHTML :string,
    public newsText :string
  ){}
}
