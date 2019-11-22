import { UserDTO } from './userdto';
import { TopicDTO } from './topicdto'; 

export class ResearchDTO {

    id: number;

    date: Date;

    researcher: UserDTO;

    topics: TopicDTO[];

}