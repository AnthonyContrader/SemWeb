import { Usertype } from './usertype';
import { ResearchDTO } from './researchdto';

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend. 
 * 
 * @see Usertype
 * 
 * @author Vittorio Valent
 */
export class UserDTO {

   id: number;

   username: string;

   password: string;

   usertype: Usertype;

   friends: UserDTO[];

   friendOf: UserDTO[];

   researches: ResearchDTO[];
}

