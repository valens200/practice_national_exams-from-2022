import { UUID } from "mongodb";
import { DataTypes, Model } from "sequelize";
const sequelize = require("../database/squalizer");

export class Book extends Model {
  private id!: UUID;
  private ISBN!: string;
  private name!: string;
}

Book.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    ISBN: {
      type: DataTypes.STRING,
    },
    name: {
      type: DataTypes.STRING,
    },
  },
  {
    sequelize: sequelize,
    modelName: "Book",
    tableName: "books",
  }
);
