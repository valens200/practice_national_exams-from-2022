const { DataTypes, Model } = require("sequelize");
const connection = require("../database/squalizer");
const squalize = require("../database/squalizer");

class User extends Model {
  private id!: number;
  private email!: string;
  private password!: string;
}

User.init(
  {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    email: {
      type: DataTypes.STRING,
    },
    password: {
      type: DataTypes.STRING,
    },
  },
  {
    sequelize: squalize,
    modelName: "User",
    tableName: "users",
  }
);
